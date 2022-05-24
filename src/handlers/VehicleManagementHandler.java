package handlers;

import components.Table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VehicleManagementHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("view_vehicles")){
            Object [][] data = {
                    {1, "SUZUKI-300","RAC 450 F","Suzuki","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {2, "NISSANI-ER45","RAF 660 A","Nissani","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {3, "AVICHRON-34","RAE 184 C","BMW","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {4, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {5, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {6, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {7, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {8, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {9, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {10, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {11, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {12, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {13, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {14, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {15, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {16, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {17, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {18, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {19, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {20, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {21, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {22, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {23, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {24, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {25, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {26, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {27, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {28, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {29, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"},
                    {30, "HYUNDAI-678","RAF 776 D","Hyundai","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has"}
            };
            Object [] columns = {"Id", "Model", "Plate number","Brand","Description"};
            new Table("Vehicles",data,columns);
        }
    }
}
