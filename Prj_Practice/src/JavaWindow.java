import java.util.List;

import javax.swing.*;
import java.awt.event.*; 


public class JavaWindow {
	
	JFrame f;
	int buttonXPos, buttonYPos,  jFrameSizeX = 1000, jFrameSizeY = 500;
	boolean orderAllowed = true;
	
	public JavaWindow(List<DishCategory> mainList){
		
		f=new JFrame();							//creating instance of JFrame
		JTextArea txtArea=new JTextArea("");	// Text area
		txtArea.setFont(txtArea.getFont().deriveFont(16.0f));
		buttonYPos = jFrameSizeY / 10 * 0 + 60;
		txtArea.setBounds(jFrameSizeX+20,buttonYPos, 320,300);  
	    f.add(txtArea);  
        
		for(int i=0; i < mainList.size(); i++){		// Labels of categories
			buttonXPos = jFrameSizeX/mainList.size()*i + 20;
			JLabel labelAny = new JLabel(mainList.get(i).getCategoryName());  
			labelAny.setBounds(buttonXPos,10, 200,50);
			labelAny.setFont(labelAny.getFont().deriveFont(18.0f));
			f.add(labelAny);
		}
		
		buttonXPos = 1000 + 20;					// Label of text area
		JLabel labelAny = new JLabel("Užsakomas maistas");
		labelAny.setBounds(buttonXPos,10, 200,50);
		labelAny.setFont(labelAny.getFont().deriveFont(18.0f));
		f.add(labelAny);
		
		JLabel labelTotal = new JLabel("Viso mokėti: ");	// Label - "total payment"
		labelTotal.setBounds(buttonXPos,360, 200,50);
		labelTotal.setFont(labelTotal.getFont().deriveFont(18.0f));
		f.add(labelTotal);
		
		JLabel lbllTotPayment = new JLabel("0.00");			// Label - total amount
		lbllTotPayment.setBounds(buttonXPos + 130, 360, 200,50);
		lbllTotPayment.setFont(lbllTotPayment.getFont().deriveFont(18.0f));
		f.add(lbllTotPayment);
		
		JButton btnOrder=new JButton ("Užsakyti");			//JButton  "Order"
		btnOrder.setBounds(buttonXPos,420,100, 40);
		btnOrder.addActionListener(new ActionListener(){  
			   public void actionPerformed(ActionEvent e){
				   if(orderAllowed){
				   txtArea.setText(txtArea.getText() + "***UŽSAKYMAS PRIIMTAS***\n");
				   orderAllowed = false;
				   }
			   }  
		});   
		f.add(btnOrder);
		
		JButton btnNewOrder=new JButton ("Naujas užsakymas");			//JButton  reset "New Order"
		btnNewOrder.setBounds(buttonXPos+170,420,150, 40);
		btnNewOrder.addActionListener(new ActionListener(){  
			   public void actionPerformed(ActionEvent e){  
				   txtArea.setText("");
				   lbllTotPayment.setText( Float.toString( 0.00f) )  ;
				   orderAllowed = true;
			           }  
			       });   
		f.add(btnNewOrder);		
		
		for(int i=0; i < mainList.size(); i++){						// loop through categories
			buttonXPos = jFrameSizeX/mainList.size()*i + 20;
			
			for(int j=0; j < mainList.get(i).getDishList().size(); j++){	// loop through dishes
				buttonYPos = jFrameSizeY / 10 * j + 60;
				JButtonPlus b=new JButtonPlus (mainList.get(i).getDishList().get(j).getDishName());//creating instance of JButton
				b.setDishName(mainList.get(i).getDishList().get(j).getDishName());
				b.setPrice(mainList.get(i).getDishList().get(j).getDishPrice());
				b.setBounds(buttonXPos,buttonYPos,200, 40);
				
				   b.addActionListener(new ActionListener(){  
					   public void actionPerformed(ActionEvent e){  
						   if(orderAllowed){
							   txtArea.setText(txtArea.getText() + b.getDishName() + "  " + b.getPrice() +  " EUR\n");
						   float totalPrice = Float.parseFloat(lbllTotPayment.getText()) + b.getPrice();
						   totalPrice = Math.round(totalPrice * 100.0f)/100.0f;
						   lbllTotPayment.setText( Float.toString( totalPrice) )  ;
						   }
					   }  
					});   
				
				f.add(b);
			}
		}
		     
		f.setSize(jFrameSizeX+400,jFrameSizeY+60);//400 width and 500 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible 
	}
}
