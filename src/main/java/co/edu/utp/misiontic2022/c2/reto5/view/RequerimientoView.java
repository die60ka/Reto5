package co.edu.utp.misiontic2022.c2.reto5.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import co.edu.utp.misiontic2022.c2.reto5.controller.RequerimientoController;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.CasaCampestreVo;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.ComprasProyectoVo;
import co.edu.utp.misiontic2022.c2.reto5.model.vo.LiderPorCiudadVo;

public class RequerimientoView extends JFrame {
    public static final RequerimientoController controller = new RequerimientoController();

    private static final long serialVersionUID = 1L;
    private JPanel contJPanel;
    private JTextArea textArea;

    public RequerimientoView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 800, 650);

        contJPanel = new JPanel();
        contJPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contJPanel);
        contJPanel.setLayout(null);

        JLabel lbTitulo = new JLabel("--Reto5--");
        lbTitulo.setBounds(28, 6, 61, 16);
        contJPanel.add(lbTitulo);

        JScrollPane scrollpane = new JScrollPane();
        scrollpane.setBounds(28, 70, 737, 455);
        contJPanel.add(scrollpane);

        textArea = new JTextArea();
        scrollpane.setViewportView(textArea);

        JButton btnConsulta1 = new JButton("Informe 1");
        btnConsulta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                informe1();
            }
        });

        btnConsulta1.setBounds(28, 537, 133, 29);
        contJPanel.add(btnConsulta1);

        JButton btnConsulta2 = new JButton("Informe 2");
        btnConsulta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                informe2();
            }
            
        });

        btnConsulta2.setBounds(180, 537, 133, 29);
        contJPanel.add(btnConsulta2);

        JButton btnConsulta3 = new JButton("Informe 3");
        btnConsulta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                informe3();
            }

        });

        btnConsulta3.setBounds(330, 537, 133, 29);
        contJPanel.add(btnConsulta3);
    }

    public void informe1() {
        try {
            ArrayList<LiderPorCiudadVo> lideres = controller.consultarLiderPorCiudad();
            String salida = "**** Asesor Por Ciudad **** \n\nId lider \t Nombre \t Primer Apellido \t Residencia\n\n";

            for (LiderPorCiudadVo lider: lideres) {
                salida += lider.getIdLider() + " \t ";
                salida += lider.getNombre() + " \t ";
                salida += lider.getApellido() + " \t\t ";
                salida += lider.getCiudad() + " \n";
            }
            textArea.setText(salida);
        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    public void informe2() {
        try {
            ArrayList<CasaCampestreVo> casas = controller.consultarCasaCampestre();
            String salida = "**** Proyecto Casa Campestre **** \n\nId Proyecto \t Constructora \t Habitaciones \t Ciudad\n\n";

            for (CasaCampestreVo casa : casas) {
                salida += casa.getIdProyecto() + " \t ";
                salida += casa.getConstructora();
                if (casa.getConstructora().length() <= 11) {
                    salida += "\t\t";
                } else {
                    salida += "\t";
                }
                salida += casa.getNumeroHabitaciones() + "\t\t";
                salida += casa.getCiudad() + "\n";
            }

            textArea.setText(salida);

        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
        }
    }

    public void informe3() {
        try {
            ArrayList<ComprasProyectoVo> compras = controller.consultarComprasProyecto();
            String salida = "**** Compras Por Proyecto ****\n\nId Compra \tConstructora  \tBanco vinculado\n\n";

            for (ComprasProyectoVo compra : compras) {
                salida += compra.getIdcompra() + "\t";
                salida += compra.getConstructora();
                if (compra.getConstructora().length() <= 9) {
                    salida +=  "\t\t";
                } else {
                    salida += "\t";
                }
                salida += compra.getBanco() + "\n";
            }

            textArea.setText(salida);

        } catch (SQLException e) {
            System.err.println("Error " + e.getMessage());
        }
    }

}