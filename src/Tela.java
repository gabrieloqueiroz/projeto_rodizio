
import com.sun.java.accessibility.util.AWTEventMonitor;
import java.io.*; // Comunicação com dispositivos (disco)
import java.awt.event.*;//ActionListener
import javax.swing.*; // Pacotes de elementos Gráficos(JFrame)
import javax.swing.table.*;//DefaultTableModel
import java.awt.*; // Dimension
import java.text.DecimalFormat;// Pacote de Formatar Elementos

// Classe "Tela" Herda Caracteristicas da Classe JFrame
public class Tela extends JFrame implements ActionListener {

    public static int idAtendimento = 1;

//Declaração Publica dos Objetos
    public static Font fntLabels = new Font("TAHOMA", Font.BOLD, 24);
    public static Font fntCxTexto = new Font("VERDANA", Font.PLAIN, 22);
    
    //Declaração MENU
    public static JMenuBar mbrTela;
    public static JMenu mnuSistema;
    public static JMenuItem mniAlterar, mniSair;
    
    
    public static Container ctnTela;

    public static JLabel lblBanner, lblVRodizio, lblQPessoas, lblTRodizio, lblAcompanhamentos,
            lblServicos, lblEstacionamento, lblTotal, lblBebidas, lblSobremesas;

    public static JTextField txtVRodizio, txtQPessoas, txtTRodizio,
            txtAcompanhamentos, txtServicos, txtTotal;

    public static JButton btnAdd, btnFecharPedido, btnBebidas[], btnSobremesas[];

    public static ImageIcon imgBanner, imgBebidas[], imgSobrimesas[];

    public static JComboBox cmbEstacionamento;

    public static JTable tblItens;

    public static JScrollPane scrItens;

    public static DefaultTableModel mdlItens;

    public static DecimalFormat fmtMoeda;

    //Método Construtor
    public Tela() {
        
        
        
        super("Sistema Gerenciador de Restaurante - CIC UNG");//Titulo da p�gina
        
        fmtMoeda = new DecimalFormat("0.00");
        
        //Construção e configuração do menu
        mbrTela = new JMenuBar();
        this.setJMenuBar(mbrTela); //add barra de menu no JFrame (janel)
        
        mnuSistema = new JMenu ("Sistema");
        mnuSistema.setMnemonic('s');
        mbrTela.add(mnuSistema);//Adicionando Menu na barra
        
        mniAlterar = new JMenuItem("Alterar valor do rodizio"); //Criando item do topico
        mniAlterar.addActionListener(this);
        mnuSistema.add(mniAlterar); //adicionando alterar no menu sistema
        
        mnuSistema.add(new JSeparator());//criando divisão
        
        mniSair = new JMenuItem("Fechar sistema"); //Criando item do topico
        mniSair.addActionListener(this);
        mnuSistema.add(mniSair); //adicionando sair no menu sistema
        
        //Instanciando objeto para comunica��o entre tela e pedido
        //Comunicação entre camadas VIEW -> VO (Atributos)
        Control.objComanda = new Pedido((float) 49.9);

        //Construção e Configuração / Add aqui
        ctnTela = new Container();//Instanciando
        ctnTela.setLayout(null);//Configurando Layout
        this.add(ctnTela);//Add Container na Janela

        //Instanciando Banner Principal
        imgBanner = new ImageIcon("img/banner.jpg"); //Inserindo Imagem
        lblBanner = new JLabel(imgBanner);
        lblBanner.setBounds(0, 0, 1360, 180);//Posicionando imagens (X,Y,Width,Height)
        ctnTela.add(lblBanner); // Adicionando Banner a tela

        //Instanciando Valor Rodizio
        lblVRodizio = new JLabel("Valor do Rod�zio: ");
        lblVRodizio.setFont(fntLabels);
        lblVRodizio.setBounds(15, 215, 250, 30);
        ctnTela.add(lblVRodizio);

        //Instanciando Valor Rodizio
        txtVRodizio = new JTextField();
        txtVRodizio.setEditable(false);
        txtVRodizio.setFont(fntCxTexto);
        txtVRodizio.setBounds(260, 220, 160, 30);
        ctnTela.add(txtVRodizio);

        //Instanciando N� de pessoas
        lblQPessoas = new JLabel("N� de pessoas: ");
        lblQPessoas.setFont(fntLabels);
        lblQPessoas.setBounds(15, 285, 250, 30);
        ctnTela.add(lblQPessoas);

        //Instanciando N� de pessoas
        txtQPessoas = new JTextField();
        txtQPessoas.setEditable(false);
        txtQPessoas.setFont(fntCxTexto);
        txtQPessoas.setBounds(260, 290, 80, 30);
        ctnTela.add(txtQPessoas);

        //Instanciando Total Rodizio
        lblTRodizio = new JLabel("Total Rodizio: ");
        lblTRodizio.setFont(fntLabels);
        lblTRodizio.setBounds(15, 355, 250, 30);
        ctnTela.add(lblTRodizio);

        //Instanciando Total Rodizio
        txtTRodizio = new JTextField();
        txtTRodizio.setEditable(false);
        txtTRodizio.setFont(fntCxTexto);
        txtTRodizio.setBounds(260, 360, 160, 30);
        ctnTela.add(txtTRodizio);

        //Instanciando Acompanhamentos
        lblAcompanhamentos = new JLabel("Acompanhamentos: ");
        lblAcompanhamentos.setFont(fntLabels);
        lblAcompanhamentos.setBounds(15, 425, 250, 30);
        ctnTela.add(lblAcompanhamentos);

        //Instanciando Acompanhamentos
        txtAcompanhamentos = new JTextField();
        txtAcompanhamentos.setEditable(false);
        txtAcompanhamentos.setFont(fntCxTexto);
        txtAcompanhamentos.setBounds(260, 430, 160, 30);
        ctnTela.add(txtAcompanhamentos);

        //Instanciando Servicos
        lblServicos = new JLabel("Servi�os: ");
        lblServicos.setFont(fntLabels);
        lblServicos.setBounds(15, 495, 250, 30);
        ctnTela.add(lblServicos);

        //Instanciando Servicos
        txtServicos = new JTextField();
        txtServicos.setEditable(false);
        txtServicos.setFont(fntCxTexto);
        txtServicos.setBounds(260, 500, 160, 30);
        ctnTela.add(txtServicos);

        //Instanciando Estacionamento
        lblEstacionamento = new JLabel("Estacionamento: ");
        lblEstacionamento.setFont(fntLabels);
        lblEstacionamento.setBounds(15, 565, 250, 30);
        ctnTela.add(lblEstacionamento);

        //Instanciando Estacionamento
        String op[] = {"N�o", "Sim"};
        cmbEstacionamento = new JComboBox(op);
        cmbEstacionamento.setFont(fntCxTexto);
        cmbEstacionamento.setBounds(260, 570, 160, 30);
        ctnTela.add(cmbEstacionamento);

        //Tratamento do 'click' na combo
        cmbEstacionamento.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent evt) {
                if (cmbEstacionamento.getSelectedIndex() == 1) {
                    Control.objComanda.stEstacionamento = true;
                } else {
                    Control.objComanda.stEstacionamento = false;
                }
                Control.objComanda.atualizarValores();
                carregarDados();
            }
        }
        );

        //Instanciando Total a Pagar
        lblTotal = new JLabel("Total a Pagar:");
        lblTotal.setFont(fntLabels);
        lblTotal.setBounds(15, 635, 250, 30);
        ctnTela.add(lblTotal);

        //Instanciando Total a Pagar
        txtTotal = new JTextField();
        txtTotal.setEditable(false);
        txtTotal.setFont(fntCxTexto);
        txtTotal.setBounds(260, 640, 160, 30);
        ctnTela.add(txtTotal);

        //Instanciando Bebidas E Sobremesas
        lblBebidas = new JLabel("Bebidas:");
        lblBebidas.setFont(fntLabels);
        lblBebidas.setBounds(880, 200, 350, 30);
        ctnTela.add(lblBebidas);

        lblSobremesas = new JLabel("Sobremesas:");
        lblSobremesas.setFont(fntLabels);
        lblSobremesas.setBounds(880, 440, 350, 30);
        ctnTela.add(lblSobremesas);

        //Instanciando Vetores de Botões (Bebidas & Sobremesas)
        btnBebidas = new JButton[8];
        btnSobremesas = new JButton[8];

        //Instanciando e Configurando cada Botão Dentro dos Vetores
        for (int i = 0; i < btnBebidas.length; i++) {

            btnBebidas[i] = new JButton(new ImageIcon("img/b" + i + ".png"));

            btnBebidas[i].addActionListener(this);
            btnBebidas[i].setToolTipText(Control.objComanda.sBebidas[i] + " - R$ " + fmtMoeda.format(Control.objComanda.vBebidas[i]));
            btnBebidas[i].setBackground(Color.white);//Mudando cor de fundo

            btnSobremesas[i] = new JButton(new ImageIcon("img/s" + i + ".png"));

            btnSobremesas[i].addActionListener(this);
            btnSobremesas[i].setToolTipText(Control.objComanda.sSobremesas[i] + " - R$ " + fmtMoeda.format(Control.objComanda.vSobremesas[i]));
            btnSobremesas[i].setBackground(Color.white);//Mudando cor de fundo

            //Posicionando Botões
            if (i < 4) {
                btnBebidas[i].setBounds(880 + (i * 65), 250, 55, 55); //Posicionando os botoes
                btnSobremesas[i].setBounds(880 + (i * 65), 480, 55, 55);//Posicionando os botoes
            } else {
                btnBebidas[i].setBounds(880 + ((i - 4) * 65), 350, 55, 55); //Posicionando os botoes
                btnSobremesas[i].setBounds(880 + ((i - 4) * 65), 580, 55, 55);//Posicionando os botoes

            }///Fechando Else

            ctnTela.add(btnBebidas[i]);
            ctnTela.add(btnSobremesas[i]);
        }//Fechando FOR

        //Instanciando Vetores de Botões (Bebidas & Sobremesas)
        //Instanciando Tabela
        tblItens = new JTable();//Instanciando TABLE
        scrItens = new JScrollPane(tblItens);//Instanciando Scroll e Vinculando Tabela
        mdlItens = (DefaultTableModel) tblItens.getModel();

        //Add Tabela
        scrItens.setBounds(480, 220, 350, 400);
        ctnTela.add(scrItens);

        //Montando topo da tabela
        String sTopo[] = {"Item", "Quantidade"};

        for (int i = 0; i < sTopo.length; i++) {
            mdlItens.addColumn(sTopo[i]);
        }

        btnFecharPedido = new JButton("Fechar Pedido");
        btnFecharPedido.addActionListener(this);
        btnFecharPedido.setFont(fntLabels);
        btnFecharPedido.setBounds(480, 640, 350, 30);
        ctnTela.add(btnFecharPedido);

        btnAdd = new JButton("+");
        btnAdd.addActionListener(this);
        btnAdd.setFont(fntLabels);
        btnAdd.setBounds(360, 290, 60, 30);
        ctnTela.add(btnAdd);

        //Chamando Método de Preenchimento dos Campos
        Control.objComanda.atualizarValores();
        carregarDados();

        //Instanciando Tabela / Encerra processo da VJM ao fechar a Janela / Fechar App no Net beans
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Encerra o Processo do Java
        this.setSize(montarTela().width, montarTela().height - 35);//Dimensões da Janela
        this.setResizable(true);//Bloqueando o Dimensinamento Opcional:(Manter "false"); Por enquanto deixando no "true"
        this.setVisible(true); //Exibe a Janela

    }//Fechando Método Construtor

    public void actionPerformed(ActionEvent evt) {

        //Método getSource recebe o nome do botão 'Clicado'
        
        if(evt.getSource() == mniSair){
            System.exit(0); // encerra o VJM
            //this.dispose();
        }
        
        if (evt.getSource() == mniAlterar){
            float novoValor = Float.parseFloat(
                              JOptionPane.showInputDialog("Entre com o novo valor: "));//Inserção do novo valor na tela
             Control.objComanda.vRodizio = novoValor;
             Control.objComanda.atualizarValores();
             carregarDados();
            
        }
        
        
        if (evt.getSource() == btnAdd) {
            Control.objComanda.qtdPessoas++;
            Control.objComanda.atualizarValores();
            carregarDados();
        }//Fechando If
        for (int i = 0; i < btnBebidas.length; i++) {
            if (evt.getSource() == btnBebidas[i]) {
                Control.objComanda.adicionarAcompanhamento(1, i);
                Control.objComanda.atualizarValores();
                carregarDados();
            } else if (evt.getSource() == btnSobremesas[i]) {
                Control.objComanda.adicionarAcompanhamento(2, i);
                Control.objComanda.atualizarValores();
                carregarDados();
            }
            atualizarTabela();

        }//Fechando FOR

        if (evt.getSource() == btnFecharPedido) {
            int resp = JOptionPane.showConfirmDialog(null,
                    "Deseja gerar nota?", "NF",
                    JOptionPane.YES_NO_OPTION);

            if (resp == JOptionPane.YES_OPTION) {
                //GRAVAR NOTA
                String cpf = JOptionPane.showInputDialog(
                        "Informe o CPF: ");
                gravarNota(cpf);
                
            }
            
            idAtendimento++;
            
            //ZERAR CAMPOS
            zerarCampos();
        }
    }//Fechando ActionPerformed

    public static Dimension montarTela() {

        Toolkit info = Toolkit.getDefaultToolkit();//Classe ToolKit - Acessa configurações do Sistema
        Dimension resolucao = info.getScreenSize();//Acessando Dimensões da Tela
        return resolucao;//Retornando Resolução

    }//Fechando Montar Tela

    public static void carregarDados() {
        //Preencher cada Campo com sua Respectiva Info
        txtVRodizio.setText("R$ " + fmtMoeda.format(Control.objComanda.vRodizio));
        txtQPessoas.setText(" " + Control.objComanda.qtdPessoas);
        txtTRodizio.setText("R$ " + fmtMoeda.format(Control.objComanda.vParcial));
        txtAcompanhamentos.setText("R$ " + fmtMoeda.format(Control.objComanda.vAcompanhamentos));
        txtServicos.setText("R$ " + fmtMoeda.format(Control.objComanda.vServicos));
        txtTotal.setText("R$ " + fmtMoeda.format(Control.objComanda.vTotal));

    }//Fechando carregarDados

    public static void atualizarTabela() {

        while (mdlItens.getRowCount() > 0) {
            mdlItens.removeRow(0);
        }//Fechando While

        //Para cada Item Encontrado na Lista de Acompanhamentos
        for (Acompanhamento item : Control.objComanda.lista) {

            String dados[] = new String[2];
            dados[0] = item.getNome();
            dados[1] = "" + item.getQuantidade();

            mdlItens.addRow(dados);

        }//Fechando For

    }//Fechando atualizarTabela

    public static void gravarNota(String tmpCpf) {

        String texto = "";
        texto += "######### RESTAURANTE CIC - 3° SEMESTRE #########\r\n\r\n";
        texto += "Av. Guarulhos, 353- Centro\r\n";
        texto += "Tel: (11) 95241-2545\r\n";
        texto += "*************** Dados do pedido ***************\r\n\r\n";
        texto += "Valor do Rodízio: R$" + Control.objComanda.vRodizio + "\r\n\r\n";
        texto += "Pessoas: " + Control.objComanda.qtdPessoas + "\r\n\r\n";
        texto += "Sub-Total: " + Control.objComanda.vParcial + "\r\n\r\n";
        for (Acompanhamento item : Control.objComanda.lista) {
            texto += item.getNome() + "------" + item.getQuantidade() + "------" + (item.getQuantidade() * item.getValor()) + "\r\n";
        }//fechando FOR

        texto += "\r\n";
        texto += "Acompanhamentos: " + Control.objComanda.vAcompanhamentos + "\r\n";
        texto += "Servicos: " + Control.objComanda.vServicos + "\r\n";

        if (Control.objComanda.stEstacionamento) {
            texto += "Estacionamento: SIM (R$ 15,00) \r\n\r\n";
        } else {
            texto += "Estacionamento NÃO \r\n\r\n";
        }
        texto += "TOTAL A PAGAR: R$" + Control.objComanda.vTotal + "\r\n\r\n\r\n";
        texto += "AGRADECEMOS A PREFERÊNCIA - VOLTE SEMPRE!!";
        
        //Gravação e escrita do arquivo
        try{
            
            String nomeArquivo ="NF_" + idAtendimento + "_" + tmpCpf + ".txt";
            //Gravando o arquivo no local e nome especificados
            FileWriter arquivo = new FileWriter("docs\\" + nomeArquivo);
            //Escrevendo conteúdo da nota no arquivo instanciado acima
            PrintWriter conteudo = new PrintWriter(arquivo);
            conteudo.write(texto);//escrevendo texto do arquivo
            //Salvando e fechando o arquivo texto
            arquivo.close();
                
            
            JOptionPane.showMessageDialog(null, "Arquivo gerado. ");
            
            //abrindo bloco de notas com o arquivo
            Runtime.getRuntime().exec("notepad C:\\Users\\Gabriel Queiroz\\Documents\\NetBeansProjects\\Restaurante\\docs\\" + nomeArquivo);
            
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null, "Falha na gravação do arquivo \nErro original: " + erro.getMessage());
        }
        
    }//fechando gravarNota
    public static void zerarCampos(){
        //limpar ArrayList
        Control.objComanda.lista.clear();
        
        //Limpar Tabela
        while(mdlItens.getRowCount() > 0){
            mdlItens.removeRow(0);
        }
        //Zerar valores e caixas de texto
        Control.objComanda.vRodizio = 49.9f;
        Control.objComanda.qtdPessoas = 1;
        Control.objComanda.vParcial = 0;
        Control.objComanda.vAcompanhamentos = 0;
        Control.objComanda.vServicos = 0;
        Control.objComanda.stEstacionamento = false;
        Control.objComanda.vTotal = 0;
        
        cmbEstacionamento.setSelectedIndex(0);//voltando pra não
        carregarDados();
    }
}//Fechando Classe
