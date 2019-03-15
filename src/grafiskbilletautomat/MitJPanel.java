package grafiskbilletautomat;

//Import to create Jframe
import javax.swing.JFrame;

//Grapical Import
import java.awt.Graphics;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.MemoryImageSource;
import java.util.ArrayList;

//timer for updatiting the clock
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Adam Aron Edelsten
 */
public class MitJPanel extends javax.swing.JPanel
{

    Timer timer = new Timer();

    TimerTask task = new TimerTask()
    {
        public void run()
        {
            //set time in the panel
            lblTiden.setText(billetAutomatKlasse.getTime());
            updateVisualPrices();
        }
    };

    private int mouseXpos;
    private int mouseYpos;

    public static ArrayList<Coin> allCoins = new ArrayList<>();

    public MitJPanel()
    { // Class constructor run 

        initComponents(); //interface components

        //placement of coingraphics
        int coinAreaOffsetX = 400;
        int coinAreaOffsetY = 200;

        //Adding different coins to the allCoins list object
        Coin HalvKrone = new Coin(coinAreaOffsetX, coinAreaOffsetY, 45, 0.5, "50ore.png");
        allCoins.add(HalvKrone);
        Coin EnKrone = new Coin(coinAreaOffsetX + 35, coinAreaOffsetY, 50, 1, "1Krone.png");
        allCoins.add(EnKrone);
        Coin ToKrone = new Coin(coinAreaOffsetX + 35 + 35, coinAreaOffsetY, 55, 2, "2Krone.png");
        allCoins.add(ToKrone);
        Coin FemKrone = new Coin(coinAreaOffsetX + 35 + 35 + 35, coinAreaOffsetY, 70, 5, "5Krone.png");
        allCoins.add(FemKrone);
        Coin TiKrone = new Coin(coinAreaOffsetX, coinAreaOffsetY + 55, 55, 10, "10Krone.png");
        allCoins.add(TiKrone);
        Coin TyevKrone = new Coin(coinAreaOffsetX + 40, coinAreaOffsetY + 55, 63, 20, "20Krone.png");
        allCoins.add(TyevKrone);

        //update prices
        updateVisualPrices();

        //start timer
        timer.scheduleAtFixedRate(task, 500, 500);
        
        updateTotal();

    }

    private void updateVisualPrices()
    {
        //update prices
        lblVoksenPris.setText(String.valueOf(billetAutomatKlasse.getBilletpris(
                billetKlasse.ticketType.VOKSEN) + " kr."));
        lblBarnPris.setText(String.valueOf(billetAutomatKlasse.getBilletpris(
                billetKlasse.ticketType.BARN) + " kr."));
        lblCykelPris.setText(String.valueOf(billetAutomatKlasse.getBilletpris(
                billetKlasse.ticketType.CYKEL) + " kr."));
    }

    //settings for the coin slot
    Image slot = Toolkit.getDefaultToolkit().getImage("slot.png");
    int slotPositionX = 435;
    int slotPositionY = 15;
    int slotWidth = 2 * 45; //for 2*  og 3* for scaling korrekt
    int slotHeight = 3 * 45;

    boolean holdingCoin = false; //Is the coin currently being dragged in the hand?
    Coin SelectedCoin; //this will contain the coin object that has been selected

    public void paintComponent(Graphics g)
    { //Drawing rutine

        super.paintComponent(g);  // tegn først baggrunden på panelet

        //draw coin slot
        g.drawImage(slot, slotPositionX, slotPositionY, slotWidth, slotHeight, this);

        //draw all the coins from allCoins list
        for (Coin element : allCoins)
        {

            g.drawImage(element.getImage(), element.getXpos(), element.getYpos(), element.getSize() - 5, element.getSize() - 5, this);

        }

        if (holdingCoin)
        { // draw the coin on the mouse position

            g.drawImage(SelectedCoin.getImage(), mouseXpos - SelectedCoin.getCenter(), mouseYpos - SelectedCoin.getCenter(), SelectedCoin.getSize(), SelectedCoin.getSize(), this);

        }
        
        

    }

//////////////////////////////////////////
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnKøb = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnVoksenPlus = new javax.swing.JButton();
        btnVoksenMinus = new javax.swing.JButton();
        txtBalance = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnBarnMinus = new javax.swing.JButton();
        btnBarnPlus = new javax.swing.JButton();
        btnCykelMinus = new javax.swing.JButton();
        btnCykelPlus = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtTotalPris = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblAdminMenu = new javax.swing.JLabel();
        btnSletAlt = new javax.swing.JButton();
        lblVoksenPris = new javax.swing.JLabel();
        lblBarnPris = new javax.swing.JLabel();
        lblCykelPris = new javax.swing.JLabel();
        lblTiden = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
        {
            public void mouseDragged(java.awt.event.MouseEvent evt)
            {
                MUSDRAGGED(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt)
            {
                musFlyttet(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                FocusGainedAndUpdatePrices(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                MusTrykkeIJframe(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
                TRYKKETNED(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt)
            {
                MUSSLUPPET(evt);
            }
        });

        btnKøb.setForeground(new java.awt.Color(248, 24, 24));
        btnKøb.setMnemonic('H');
        btnKøb.setText("Køb");
        btnKøb.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnKøbActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(27, 112, 0));
        jLabel1.setText("Køb Billeter til enkeltrejse");

        btnVoksenPlus.setLabel("+1");
        btnVoksenPlus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnVoksenPlusActionPerformed(evt);
            }
        });

        btnVoksenMinus.setText("-1");
        btnVoksenMinus.setEnabled(false);
        btnVoksenMinus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnVoksenMinusActionPerformed(evt);
            }
        });

        txtBalance.setEditable(false);
        txtBalance.setText("0");
        txtBalance.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txtBalance.setFocusable(false);
        txtBalance.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtBalanceActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Balance:");

        btnBarnMinus.setText("-1");
        btnBarnMinus.setEnabled(false);
        btnBarnMinus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBarnMinusActionPerformed(evt);
            }
        });

        btnBarnPlus.setText("+1");
        btnBarnPlus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBarnPlusActionPerformed(evt);
            }
        });

        btnCykelMinus.setText("-1");
        btnCykelMinus.setEnabled(false);
        btnCykelMinus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCykelMinusActionPerformed(evt);
            }
        });

        btnCykelPlus.setText("+1");
        btnCykelPlus.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnCykelPlusActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Voksen billet:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Cykel billet");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Børne billet");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {"", null, null},
                {"", null, null},
                {null, null, null},
                {null, null, null}
            },
            new String []
            {
                "Billet", "Antal", "Samlet pris"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jTable1.setAutoscrolls(false);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setFocusable(false);
        jTable1.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0)
        {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        txtTotalPris.setText("Total pris: 0");
        txtTotalPris.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                txtTotalPrisActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        lblAdminMenu.setFont(new java.awt.Font("DejaVu Sans", 0, 24)); // NOI18N
        lblAdminMenu.setForeground(new java.awt.Color(153, 153, 153));
        lblAdminMenu.setText("⚙");
        lblAdminMenu.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                AdminMenu(evt);
            }
        });

        btnSletAlt.setText("Slet alt");
        btnSletAlt.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSletAltActionPerformed(evt);
            }
        });

        lblVoksenPris.setText("Kr.");

        lblBarnPris.setText("Kr.");

        lblCykelPris.setText("Kr.");

        lblTiden.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTiden.setText("TID");

        jButton14.setText("↓");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lblVoksenPris, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnVoksenMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(29, 29, 29)
                                .addComponent(lblBarnPris, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(btnBarnMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(43, 43, 43)
                                .addComponent(lblTiden, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblAdminMenu))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(33, 33, 33)
                                            .addComponent(jButton14)))
                                    .addGap(18, 18, 18)
                                    .addComponent(lblCykelPris, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addComponent(btnCykelMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(2, 2, 2)
                                    .addComponent(btnCykelPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(210, 210, 210)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnBarnPlus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnVoksenPlus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(9, 9, 9)
                                .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnKøb, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txtTotalPris, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnSletAlt)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblAdminMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblTiden))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnVoksenMinus)
                                        .addComponent(btnVoksenPlus))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(lblVoksenPris)))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(lblBarnPris)
                            .addComponent(btnBarnMinus)
                            .addComponent(btnBarnPlus))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCykelPris)
                            .addComponent(btnCykelMinus)
                            .addComponent(btnCykelPlus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2))
                            .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnKøb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalPris, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSletAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
/////////////////////////////////////////


  private void btnKøbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKøbActionPerformed
      if (billetAutomatKlasse.getBalance() < 2)
      {
      }

      JFrame fra = new JFrame();
      JOptionPane.showMessageDialog(fra,
              "     ___      _____  \n"
              + "    |   _  )    |_     _| \n"
              + "    |   _ \\        |   |   \n"
              + "    |___/     _|_|_  \n"
              + "_|\"\"\"\"\"|_|\"\"\"\"\"| \n"
              + "\"`-0-0-'\"`-0-0-' \n"
      );

      repaint();
  }//GEN-LAST:event_btnKøbActionPerformed

  private void musFlyttet(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_musFlyttet

      mouseXpos = evt.getX();
      mouseYpos = evt.getY();
      repaint();

  }//GEN-LAST:event_musFlyttet

    public int counter = 0;

    private void updateTotal()
    {
        int antal = 0;
        double pris = 0;
                
        antal = billetAutomatKlasse.VoksenBilletter.size() +
                billetAutomatKlasse.BørneBilletter.size() +
                billetAutomatKlasse.CykelBilletter.size();
        
        pris  = billetAutomatKlasse.getAdultTotal() +
                billetAutomatKlasse.getChildTotal() +
                billetAutomatKlasse.getBikeTotal();

        System.out.println(pris);
        System.out.println(antal);
        
        jTable1.setValueAt("Total", 3, 0);
        jTable1.setValueAt(antal, 3, 1);
        jTable1.setValueAt(pris, 3, 2);
    }

  private void btnVoksenMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoksenMinusActionPerformed
      final int column = 0;
      if (billetAutomatKlasse.VoksenBilletter.size() > 0)
      {

          billetAutomatKlasse.VoksenBilletter.remove(0);
      }

      if (billetAutomatKlasse.VoksenBilletter.isEmpty())
      {
          btnVoksenMinus.setEnabled(false);
          // nulstiller rækken
          for (int i = 0; i < jTable1.getColumnCount(); i++)
          {
              jTable1.setValueAt(null, column, i);
          }
      }
      else
      {
          // sætter antal
          jTable1.setValueAt(billetAutomatKlasse.VoksenBilletter.size(), column, 1);

          // regner summen ud
          double pris = billetAutomatKlasse.VoksenBilletter.size()
                  * billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.VOKSEN);
          jTable1.setValueAt(pris, column, 2);
      }
      updateTotal();
  }//GEN-LAST:event_btnVoksenMinusActionPerformed

  private void MusTrykkeIJframe(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MusTrykkeIJframe
      //System.out.println("Tykket: " + xpos + ", " + ypos);
  }//GEN-LAST:event_MusTrykkeIJframe

  private void MUSDRAGGED(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MUSDRAGGED

      mouseXpos = evt.getX();
      mouseYpos = evt.getY();

      repaint();

  }//GEN-LAST:event_MUSDRAGGED


  private void TRYKKETNED(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TRYKKETNED

      for (Coin element : allCoins)
      { //run through all coins
          if (mouseXpos >= element.getXpos() && mouseXpos <= element.getXpos() + element.getSize()//check if any coin is in range of mouse xpos and mouse y
                  && mouseYpos >= element.getYpos() && mouseYpos <= element.getYpos() + element.getSize())
          {

              SelectedCoin = element;

              holdingCoin = true;

          }
      }

      if (holdingCoin)
      {
          hideCursor();
      }

  }//GEN-LAST:event_TRYKKETNED

  private void MUSSLUPPET(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MUSSLUPPET

      if (holdingCoin)
      {
          if (mouseXpos >= slotPositionX && mouseXpos <= slotPositionX + slotWidth //check if any coin is in range of mouse xpos and mouse y
                  && mouseYpos >= slotPositionY && mouseYpos <= slotPositionY + slotHeight)
          {

              double balance = billetAutomatKlasse.getBalance();
              billetAutomatKlasse.setBalance(balance + SelectedCoin.getValue());

              System.out.println(SelectedCoin.getValue() + " kr. has been added!!");
              System.out.println("Balance is now: " + billetAutomatKlasse.getBalance());

              txtBalance.setText(String.valueOf(billetAutomatKlasse.getBalance()));

              SoundPlayer.play("CoinIn.wav");
          }
          else
          {
              SoundPlayer.play("CoinLost.wav");

          }
      }

      holdingCoin = false;
      showCursor();
      repaint();

  }//GEN-LAST:event_MUSSLUPPET

    private void hideCursor()
    {
        // http://www.java2s.com/Code/Java/2D-Graphics-GUI/HidethemousecursoruseatransparentGIFasthecursor.htm
        int[] pixels = new int[16 * 16];
        Image image = Toolkit.getDefaultToolkit().createImage(
                new MemoryImageSource(16, 16, pixels, 0, 16));
        Cursor transparentCursor = Toolkit.getDefaultToolkit().createCustomCursor(
                image, new Point(0, 0), "invisibleCursor");

        setCursor(transparentCursor);

        repaint();
    }

    private void showCursor()
    {
        setCursor(Cursor.getDefaultCursor());
    }


  private void btnBarnPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarnPlusActionPerformed
      final int column = 1;
      btnBarnMinus.setEnabled(true);
      billetKlasse BørneBillet = new billetKlasse(billetKlasse.ticketType.BARN, 5, "");
      billetAutomatKlasse.BørneBilletter.add(BørneBillet);

      //TODO: muligvis skal teksten hentes et sted fra?
      jTable1.setValueAt("Barn", column, 0);

      // sætter antal
      jTable1.setValueAt(billetAutomatKlasse.BørneBilletter.size(), column, 1);

      // regner summen ud
      //TODO: muligvis dette skal hentes fra et sted af?
      double pris = billetAutomatKlasse.BørneBilletter.size()
              * billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.BARN);
      jTable1.setValueAt(pris, column, 2);
      
      updateTotal();
  }//GEN-LAST:event_btnBarnPlusActionPerformed

  private void btnCykelMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCykelMinusActionPerformed
      final int column = 2;
      if (billetAutomatKlasse.CykelBilletter.size() > 0)
      {

          billetAutomatKlasse.CykelBilletter.remove(0);
      }

      if (billetAutomatKlasse.CykelBilletter.isEmpty())
      {
          btnCykelMinus.setEnabled(false);
          // nulstiller rækken
          for (int i = 0; i < jTable1.getColumnCount(); i++)
          {
              jTable1.setValueAt(null, column, i);
          }
      }
      else
      {
          // sætter antal
          jTable1.setValueAt(billetAutomatKlasse.CykelBilletter.size(), column, 1);

          // regner summen ud
          double pris = billetAutomatKlasse.CykelBilletter.size()
                  * billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.CYKEL);
          jTable1.setValueAt(pris, column, 2);
      }
      
      updateTotal();
  }//GEN-LAST:event_btnCykelMinusActionPerformed

  private void txtBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBalanceActionPerformed
      // TODO add your handling code here:
  }//GEN-LAST:event_txtBalanceActionPerformed

  private void txtTotalPrisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPrisActionPerformed
      // TODO add your handling code here:
  }//GEN-LAST:event_txtTotalPrisActionPerformed

  private void AdminMenu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdminMenu
      // TODO add your handling code here:
      System.out.println("Pin code window opened");

      IndtastKodePanel panel = new IndtastKodePanel();        // opret panelet

      JFrame IndtastKodePanelVindue = new JFrame("IndtastKodePanel");    // opret et vindue på skærmen
      IndtastKodePanelVindue.add(panel);

      IndtastKodePanelVindue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // reagér på luk
      IndtastKodePanelVindue.pack();                       // sæt vinduets størrelse
      IndtastKodePanelVindue.setResizable(false);
      IndtastKodePanelVindue.setVisible(true);                      // åbn vinduet
      IndtastKodePanelVindue.toFront();
      IndtastKodePanelVindue.requestFocus();// vis panelet i vinduet
      IndtastKodePanelVindue.setAlwaysOnTop(true);

  }//GEN-LAST:event_AdminMenu

  private void btnSletAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSletAltActionPerformed
      btnVoksenMinus.setEnabled(false);
      btnBarnMinus.setEnabled(false);
      btnCykelMinus.setEnabled(false);

      billetAutomatKlasse.VoksenBilletter.removeAll(billetAutomatKlasse.VoksenBilletter);
      billetAutomatKlasse.BørneBilletter.removeAll(billetAutomatKlasse.BørneBilletter);
      billetAutomatKlasse.CykelBilletter.removeAll(billetAutomatKlasse.CykelBilletter);


      for (int i = 0; i < jTable1.getRowCount() - 1; i++)
      {
          for (int j = 0; j < jTable1.getColumnCount(); j++)
          {
              jTable1.setValueAt(null, i, j);
          }
      }
      updateTotal();
  }//GEN-LAST:event_btnSletAltActionPerformed

    private void btnVoksenPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoksenPlusActionPerformed
        btnVoksenMinus.setEnabled(true);
        billetKlasse VoksenBillet = new billetKlasse(billetKlasse.ticketType.VOKSEN, 5, "");
        billetAutomatKlasse.VoksenBilletter.add(VoksenBillet);

        //TODO: muligvis skal teksten hentes et sted fra?
        jTable1.setValueAt("Voksen", 0, 0);

        // sætter antal
        jTable1.setValueAt(billetAutomatKlasse.VoksenBilletter.size(), 0, 1);

        // regner summen ud
        double pris = billetAutomatKlasse.VoksenBilletter.size()
                * billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.VOKSEN);
        jTable1.setValueAt(pris, 0, 2);
        
        updateTotal();
    }//GEN-LAST:event_btnVoksenPlusActionPerformed

    private void btnBarnMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarnMinusActionPerformed
        final int column = 1;
        if (billetAutomatKlasse.BørneBilletter.size() > 0)
        {

            billetAutomatKlasse.BørneBilletter.remove(0);
        }

        if (billetAutomatKlasse.BørneBilletter.isEmpty())
        {
            btnBarnMinus.setEnabled(false);
            // nulstiller rækken
            for (int i = 0; i < jTable1.getColumnCount(); i++)
            {
                jTable1.setValueAt(null, column, i);
            }
        }
        else
        {
            // sætter antal
            jTable1.setValueAt(billetAutomatKlasse.BørneBilletter.size(), column, 1);

            // regner summen ud
            double pris = billetAutomatKlasse.BørneBilletter.size()
                    * billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.BARN);
            jTable1.setValueAt(pris, column, 2);
        }
        
        updateTotal();
    }//GEN-LAST:event_btnBarnMinusActionPerformed

    private void btnCykelPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCykelPlusActionPerformed
        final int column = 2;
        btnCykelMinus.setEnabled(true);
        billetKlasse CykelBillet = new billetKlasse(billetKlasse.ticketType.CYKEL, 5, "");
        billetAutomatKlasse.CykelBilletter.add(CykelBillet);

        //TODO: muligvis skal teksten hentes et sted fra?
        jTable1.setValueAt("Cykel", column, 0);

        // sætter antal
        jTable1.setValueAt(billetAutomatKlasse.CykelBilletter.size(), column, 1);

        // regner summen ud
        double pris = billetAutomatKlasse.CykelBilletter.size()
                * billetAutomatKlasse.getBilletpris(billetKlasse.ticketType.CYKEL);
        jTable1.setValueAt(pris, column, 2);
        
        updateTotal();
    }//GEN-LAST:event_btnCykelPlusActionPerformed

    private void FocusGainedAndUpdatePrices(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FocusGainedAndUpdatePrices

    }//GEN-LAST:event_FocusGainedAndUpdatePrices

    private void updateTable()
    {
        //Collections.so
        //billetAutomatKlasse.Kurv.sort(c);
/*
        Collections.sort(billetAutomatKlasse.Kurv, new Comparator<billetKlasse>() {
            public double compare(billetKlasse s1, billetKlasse s2) {
                return s1.getPrice().compareToIgnoreCase(s2.getPrice());
            }
        });
         */

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBarnMinus;
    private javax.swing.JButton btnBarnPlus;
    private javax.swing.JButton btnCykelMinus;
    private javax.swing.JButton btnCykelPlus;
    private javax.swing.JButton btnKøb;
    private javax.swing.JButton btnSletAlt;
    private javax.swing.JButton btnVoksenMinus;
    private javax.swing.JButton btnVoksenPlus;
    private javax.swing.JButton jButton14;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAdminMenu;
    private javax.swing.JLabel lblBarnPris;
    private javax.swing.JLabel lblCykelPris;
    private javax.swing.JLabel lblTiden;
    private javax.swing.JLabel lblVoksenPris;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtTotalPris;
    // End of variables declaration//GEN-END:variables
}
