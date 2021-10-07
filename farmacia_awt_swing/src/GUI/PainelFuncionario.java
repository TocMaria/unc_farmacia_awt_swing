package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


import DAO.FuncionarioDAO;
import Models.Funcionario;

public class PainelFuncionario extends JPanel implements ActionListener {
	private JTextField textFieldNome;
	private JTextField textFieldCPF;
	private JTextField textFieldRG;
	private JTextField textFieldEndereco;
	private JTextField textFieldTelefone;
	private JTextField textFieldPasep;
	private JTextField textFieldCarteiraTrabalho;
	private JTextField textFieldSalario;
	private JLabel labelNome;
	private JLabel labelCPF;
	private JLabel labelRG;
	private JLabel labelEndereco;
	private JLabel labelTelefone;	
	private JLabel labelPis;
	private JLabel labelPasep;
	private JLabel labelCarteiraTrabalho;
	private JLabel labelSalario;
	private double salario;
	
	private FuncionarioDAO funcionarioDao;
	private JButton btnSalvar;
	private JButton btnCancelar;
	private JTextField textFieldPis;
	
	public PainelFuncionario() {
		GridLayout gd = new GridLayout(0, 2);
		setLayout(gd);
		funcionarioDao = new FuncionarioDAO();
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(this);
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		textFieldNome = new JTextField(40);
		labelNome = new JLabel("Nome do Cliente:");
		textFieldCPF = new JTextField(40);
		labelCPF = new JLabel("CPF:");
		textFieldRG = new JTextField(40);
		labelRG = new JLabel("RG:");
		textFieldEndereco = new JTextField(40);
		labelEndereco = new JLabel("Endereco:");
		textFieldTelefone = new JTextField(40);
		labelTelefone = new JLabel("Telefone:");
		textFieldPis = new JTextField(40);
		labelPis = new JLabel("PIS:");
		textFieldPasep = new JTextField(40);
		labelPasep = new JLabel("Pasep:");
		textFieldCarteiraTrabalho = new JTextField(40);
		labelCarteiraTrabalho = new JLabel("Carteira Trabalho:");
		textFieldSalario = new JTextField(40);
		labelSalario = new JLabel("Salario:");
		add(labelNome);
		add(textFieldNome);
		add(labelCPF);
		add(textFieldCPF);
		add(labelRG);
		add(textFieldRG);
		add(labelEndereco);
		add(textFieldEndereco);
		add(labelTelefone);
		add(textFieldTelefone);
		add(labelPis);
		add(textFieldPis);
		add(labelPasep);
		add(textFieldPasep);
		add(labelCarteiraTrabalho);
		add(textFieldCarteiraTrabalho);
		add(labelSalario);
		add(textFieldSalario);
		salario= Double.parseDouble(textFieldSalario.getText());			
		add(btnCancelar);
		add(btnSalvar);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSalvar) {
			Funcionario func = new Funcionario(textFieldNome.getText(), textFieldCPF.getText(), textFieldRG.getText(), 
					textFieldEndereco.getText(), textFieldTelefone.getText(), textFieldPis.getText(),
					textFieldPasep.getText(),textFieldCarteiraTrabalho.getText(), salario);
			try {
				funcionarioDao.inserir(func);
				JOptionPane.showMessageDialog(this, "O funcionário foi salvo!", TOOL_TIP_TEXT_KEY, JOptionPane.OK_OPTION);
				limparFormulario();
				this.setVisible(false);
			} catch (Exception err) {
				JOptionPane.showMessageDialog(this, "Erro ao salvar o funcionario!", TOOL_TIP_TEXT_KEY,
						JOptionPane.ERROR_MESSAGE);
			}
		} else if (e.getSource() == btnCancelar) {
			this.setVisible(false);
		}
	}
	private void limparFormulario() {
		textFieldNome.setText(null);
		textFieldCPF.setText(null);
		textFieldRG.setText(null);
		textFieldTelefone.setText(null);
		textFieldEndereco.setText(null);
		textFieldPis.setText(null);
		textFieldPasep.setText(null);
		textFieldCarteiraTrabalho.setText(null);
		textFieldSalario.setText(null);
	}

}
