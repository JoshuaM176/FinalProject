package coms3620.fashion.menus.logistics.manage_orders;

import coms3620.fashion.departments.logistics.LogisticsManager;
import coms3620.fashion.menus.Menu;
import coms3620.fashion.menus.Option;

public class ManageOrders extends Menu implements Option {

    public ManageOrders() {
        LogisticsManager logisticsManager = new LogisticsManager();

        CreateOrder createOrder = new CreateOrder(logisticsManager);
        ViewOrders viewOrders = new ViewOrders(logisticsManager);
        DeleteOrder deleteOrder = new DeleteOrder(logisticsManager);

        addOption(createOrder);
        addOption(viewOrders);
        addOption(deleteOrder);
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
