package navegacion;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ventana2 extends JFrame {

	
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana2 frame = new ventana2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	
	static int posicion = 0;
	respuestas r = new respuestas();
	preguntas p = new preguntas();
	

	/**
	 * Create the frame.
	 */
	public ventana2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton Terminar = new JButton("Terminar - >");
		Terminar.setFont(new Font("Times New Roman", Font.BOLD, 15));
		Terminar.addActionListener(new ActionListener() {
			private Object[] select;

			public void actionPerformed(ActionEvent e) {
				int calificacion = 0;
				
				for(int i = 0; i<5; i++ ) {
					if(select[i].equals(r.getRespuesta(posicion))) {
						calificacion = calificacion + 1;
					}
				}
				
				calificacion = calificacion * 1;
				
				JOptionPane.showMessageDialog(null, "tu calificacion es "  +  calificacion);
			}
		});
		
		JRadioButton opc1 = new JRadioButton("");
		
		JRadioButton opc2 = new JRadioButton("");
		
		JRadioButton opc3 = new JRadioButton("");
				
		JRadioButton opc4 = new JRadioButton("");
		
		JRadioButton opc5 = new JRadioButton("");
		
		
		
		JLabel lblNewLabel = new JLabel("Examen");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel quest = new JLabel("Pregunta1?");
		
		JButton Avanzar = new JButton("Avanzar ->>");
		Avanzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				posicion++;
				
				if(posicion<5) {
					posicion++;
					quest.setText(p.getPregunta(posicion));
					String[] a = r.setRespuestas(posicion);
					opc1.setText(a[0]);
					opc2.setText(a[1]);
					opc3.setText(a[2]);
					opc4.setText(a[3]);
					opc5.setText(a[4]);
					opc1.requestFocus();
				}else {
					Toolkit.getDefaultToolkit().beep();
				}
			}
		});
		Avanzar.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
									.addComponent(Avanzar))
								.addComponent(opc1)
								.addComponent(opc2)
								.addComponent(opc3)
								.addComponent(opc4)
								.addComponent(opc5)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(63)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addComponent(quest))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(299, Short.MAX_VALUE)
							.addComponent(Terminar)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(quest)
							.addGap(29)
							.addComponent(opc5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(opc4)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(opc3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(opc2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(opc1)
							.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(Avanzar)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(Terminar)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}
}
