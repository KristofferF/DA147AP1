package p1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Stationary
 *
 */
public class Input extends JFrame {
	private Controller mController;
	private final String[] mLabels = { "Titel", "F�rfattare", "ISBN" };
	private JPanel mWestPanel;
	private JPanel mEastPanel;
	private JPanel mSouthPanel;
	private JButton mAddButton;
	private JButton mClearButton;
	private JTextField mTitle;
	private JTextField mAuthor;
	private JTextField mIsbn;

	/**
	 * @param controller
	 */
	public Input(Controller controller) {
		mController = controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500, 150));
		mWestPanel = new JPanel(new GridLayout(mLabels.length, 1));
		mEastPanel = new JPanel(new GridLayout(mLabels.length, 1));
		mSouthPanel = new JPanel(new GridLayout(2, 1));
		setupWestPanel();
		setupEastPanel();
		setupSouthPanel();
		setLayout(new BorderLayout());
		add(mWestPanel, BorderLayout.WEST);
		add(mEastPanel, BorderLayout.CENTER);
		add(mSouthPanel, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		pack();
		setVisible(true);
	}

	/**
	 * 
	 */
	private void setupSouthPanel() {
		mAddButton = new JButton("L�gg Till Bok");
		mClearButton = new JButton("T�m biblioteket");
		mSouthPanel.add(mAddButton);
		mSouthPanel.add(mClearButton);
		mAddButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handleInput();
			}
		});
		mClearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mController.emptyLibrary();
			}
		});

	}

	/**
	 * 
	 */
	private void setupWestPanel() {
		for (int i = 0; i < mLabels.length; i++) {
			mWestPanel.add(new JLabel(mLabels[i]));
		}
	}

	/**
	 * 
	 */
	private void setupEastPanel() {
		mTitle = new JTextField();
		mAuthor = new JTextField();
		mIsbn = new JTextField();
		mEastPanel.add(mTitle);
		mEastPanel.add(mAuthor);
		mEastPanel.add(mIsbn);
	}

	/**
	 * 
	 */
	private void clearFields() {
		mTitle.setText("");
		mAuthor.setText("");
		mIsbn.setText("");
	}

	private void handleInput() {
		if (mTitle.getText().equals("") || mAuthor.getText().equals("") || mIsbn.getText().equals("")) {
			javax.swing.JOptionPane.showMessageDialog(null, "Du m�ste fylla i alla f�lten.", "Fel p� inmatning", JOptionPane.WARNING_MESSAGE);
		} else {
			mController.newBook(mTitle.getText(), mAuthor.getText(), mIsbn.getText());
			clearFields();
		}
	}

	private void showQuestionDialog() {
		int selectedOption =
				JOptionPane.showConfirmDialog(null, "Vill du verkligen ta bort hela biblioteket?\nDu kan inte �ngra dig.", "V�lj", JOptionPane.YES_NO_OPTION);
		if (selectedOption == JOptionPane.YES_OPTION) {
			mController.emptyLibrary();
		}

	}

}
