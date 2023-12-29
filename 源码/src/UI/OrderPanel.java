package UI;

import BusinessLogic.Order;

import javax.swing.*;
import java.awt.*;

public class OrderPanel extends JFrame
{
    private JPanel ordersPanel;
    private final static int COLUMN = 1;
    private GridBagConstraints c;
    private Order order;

    public OrderPanel(Order order){
        super("Food tester");
        this.setLayout(new FlowLayout());
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        this.order = order;

        ordersPanel = new JPanel();

        JScrollPane scrollPane = new JScrollPane(ordersPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(10);

        //LAYOUT PROPERTIES HERE
        ordersPanel.setLayout(new GridLayout(100, 1) );
        c = new GridBagConstraints();
        c.insets = new Insets(0, 0, 5, 0);

        initCategoriesPanel();

        scrollPane.setViewportView(ordersPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();

        setVisible(true);
        setPreferredSize(new Dimension(310, 630));
        setSize(330, 630);
    }

    //ORDERS GENERATION HERE
    public void initCategoriesPanel(){
        ordersPanel.removeAll();
        for(int i = 0; i < order.getSize(); i++){
            c.gridx = i % COLUMN;
            c.gridy = i / COLUMN;
            SingleOrderPanel singleOrderPanel = new SingleOrderPanel( order.getFoods().get(i) );
            ordersPanel.add(singleOrderPanel, c);
        }
        ordersPanel.revalidate();
        ordersPanel.updateUI();
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}