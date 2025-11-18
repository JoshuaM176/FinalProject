package coms3620.fashion.menus.logistics.manage_orders;

import coms3620.fashion.departments.logistics.LogisticsManager;
import coms3620.fashion.menus.Menu;
import coms3620.fashion.menus.Option;

public class ManageOrders extends Menu implements Option {

    public ManageOrders(LogisticsManager lm) {
        CreateOrder createOrder = new CreateOrder(lm);
        ViewOrders viewOrders = new ViewOrders(lm);
        DeleteOrder deleteOrder = new DeleteOrder(lm);
        ViewAvailableProducts viewAvailableProducts = new ViewAvailableProducts(lm);

        addOption(createOrder);
        addOption(viewOrders);
        addOption(deleteOrder);
        addOption(viewAvailableProducts);
    }

    @Override
    public String getName() {
        return "Manage Orders";
    }

    @Override
    public void run() {
        enter_menu();
    }
}
