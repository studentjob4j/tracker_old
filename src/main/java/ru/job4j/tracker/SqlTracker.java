package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Создаем подключение к БД - создаем таблицу - вводим данные - обновляем их - получаем из БД все заявки,
 * заявки по имени, по айди - удаляем заявку по айди - удалеем таблицу - закрываем соединение с БД
 * @author Shegai Evgenii
 * @since 11.10.2021
 * @version 1.0
 *
 */

public class SqlTracker implements Store {

    private Connection connection;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public void createTable(String tableName) {
        try (Statement statement = connection.createStatement()) {
            String temp = String.format("create table %s (%s, %s, %s);",
                    tableName, "id serial primary key", "name text", "created TIMESTAMP");
            statement.execute(temp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropTable(String name) {
        try (Statement statement = connection.createStatement()) {
            String temp = String.format("drop table %s;", name);
            statement.execute(temp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Для того чтобы получить id сгенерированное БД. Нужно при создании PrepareStatement
     * вторым аргументом передать
     * Statement.RETURNING_GENERATED_KEYS. После как обычно выполнить запрос.
     * Наконец, чтобы получить ключ нужно вызвать метод getGeneratedKeys().
     * @param item
     * @return item
     */

    @Override
    public Item add(Item item) {
            try (PreparedStatement statement =
                    connection.prepareStatement("insert into items(name, created) values (?, ?)",
                    Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            Timestamp timestamp = Timestamp.valueOf(item.getCreated());
            statement.setTimestamp(2, timestamp);
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement =
            connection.prepareStatement("update items set name = ? where id = ?")) {
                statement.setString(1, item.getName());
                statement.setInt(2, id);
                result = statement.executeUpdate() > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        }


    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("delete from items  where id = ?")) {
            statement.setInt(1, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("select * from items;")) {
            ResultSet resultSet =  statement.executeQuery();
            while (resultSet.next()) {
                Item temp = new Item();
                temp.setName((resultSet.getString("name")));
                temp.setId(resultSet.getInt("id"));
                temp.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                result.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
            try (PreparedStatement statement
                         = connection.prepareStatement("select * from items where name = ?;")) {
                statement.setString(1, key);
                Item temp = new Item();
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    temp.setName(resultSet.getString("name"));
                    temp.setId(resultSet.getInt("id"));
                    temp.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                    result.add(temp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return result;
        }

    @Override
    public Item findById(int id) {
        Item result = new Item();
        try (PreparedStatement statement
                     = connection.prepareStatement("select * from items where id = ?;")) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    result.setName(resultSet.getString("name"));
                    result.setId(resultSet.getInt("id"));
                    result.setCreated(resultSet.getTimestamp("created").toLocalDateTime());
                }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws SQLException {
        SqlTracker tracker = new SqlTracker();
        tracker.init();
        tracker.createTable("items");
        System.out.println(tracker.add(new Item("test")));
        System.out.println(tracker.replace(1, new Item("test2")));
        tracker.findAll().stream().forEach(System.out::println);
        tracker.findByName("test2").stream().forEach(System.out::println);
        System.out.println(tracker.findById(1));
        tracker.dropTable("items");
        tracker.close();
    }
}
