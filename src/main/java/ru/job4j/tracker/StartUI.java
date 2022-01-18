package ru.job4j.tracker;

import java.util.List;

/**
 * @author Evgenii Shegai
 * @since 31.08.2021
 * @version 1.0
 */

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, MemTracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Выберите пункт меню");
            if (select < 0 || select > actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu: ");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Output out = new ConsoleOutput();
        Input input = new ValidateInput(out, new ConsoleInput());
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = List.of(
                new CreateAction(out), new ShowAllAction(), new EditItemAction(out), new DeleteItemAction(out),
                new FindByIdAction(out), new FindByNameAction(out), new ExitAction(out));

        new StartUI(out).init(input, tracker, actions);
    }
}
