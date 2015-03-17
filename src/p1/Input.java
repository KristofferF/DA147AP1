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
 * Input class to handle the input window
 * @author Kristoffer Freiholtz
 * @version 1.0
 */
public class Input extends JFrame {
	private Controller mController;
	private final String[] mLabels = { "Titel", "Författare", "ISBN" };
	private JPanel mWestPanel;
	private JPanel mEastPanel;
	private JPanel mSouthPanel;
	private JButton mAddButton;
	private JButton mClearButton;
	private JTextField mTitle;
	private JTextField mAuthor;
	private JTextField mIsbn;

	/**
	 * The constructor of the input window. Adds the labels, textfields and buttons and set it visible
	 * @param controller the controller to direct the inputs
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
	 * Setup of the south panel and handling button actions
	 */
	private void setupSouthPanel() {
		mAddButton = new JButton("Lägg Till Bok");
		mClearButton = new JButton("Töm biblioteket");
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
	 * Setup of the west panel with the labels
	 */
	private void setupWestPanel() {
		for (int i = 0; i < mLabels.length; i++) {
			mWestPanel.add(new JLabel(mLabels[i]));
		}
	}

	/**
	 * Setup of the East panel with the textfields
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
	 * Clear all textfields
	 * Usually after a new book is submitted
	 */
	private void clearFields() {
		mTitle.setText("");
		mAuthor.setText("");
		mIsbn.setText("");
	}

	/**
	 * Checks if all textfields are filled in other wise show an error message
	 * if correctly filled it will submit the new book to the library
	 */
	private void handleInput() {
		if (mTitle.getText().equals("") || mAuthor.getText().equals("") || mIsbn.getText().equals("")) {
			javax.swing.JOptionPane.showMessageDialog(null, "Du måste fylla i alla fälten.", "Fel på inmatning", JOptionPane.WARNING_MESSAGE);
		} else {
			mController.newBook(mTitle.getText(), mAuthor.getText(), mIsbn.getText());
			clearFields();
		}
	}
}
