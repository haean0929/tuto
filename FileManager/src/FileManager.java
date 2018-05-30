import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileFilter;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.table.DefaultTableModel;

public class FileManager extends JFrame {

	JTree tree;
	DefaultTreeModel treeModel;
	DefaultMutableTreeNode root;

	public FileManager() {
		super("home");
		root = new DefaultMutableTreeNode("디스크 드라이브(C:)");
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		DefaultTableModel model = new DefaultTableModel(new Object[0][3], new Object[] { "Name", "Size", "Modifeid" });
		JTable ta = new JTable(model);

		JScrollPane sc2 = new JScrollPane();

		JPanel top = new JPanel();
		JPanel left = new JPanel(new BorderLayout());
		JPanel center = new JPanel(new BorderLayout());
		JPanel low = new JPanel();

		// 아래쪽
		JComboBox box = new JComboBox();
		JLabel labellow = new JLabel("File Exploer");

		box.addItem("한국어");
		box.addItem("English");

		low.setLayout(new BorderLayout());
		low.add(labellow, BorderLayout.WEST);
		low.add(box, BorderLayout.EAST);

		// 위쪽
		JLabel labeltop = new JLabel("home");

		// 왼쪽
		top.setLayout(new BorderLayout());
		top.add(labeltop, BorderLayout.WEST);

		JScrollPane sc = new JScrollPane(tree);
		sc.setPreferredSize(new Dimension(200, -1));
		left.add(sc);

		// 가운데

		sc2.setViewportView(ta);
		;
		center.add(sc2);

		top.setBackground(Color.LIGHT_GRAY);
		left.setBackground(Color.WHITE);
		center.setBackground(Color.WHITE);
		low.setBackground(Color.white);

		setLayout(new BorderLayout());
		add(top, BorderLayout.NORTH);
		add(left, BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		add(low, BorderLayout.SOUTH);

		setSize(500, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		File dir = new File("C:\\");
		File[] files = dir.listFiles();
		FileFilter fileFilter = new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};
		files = dir.listFiles(fileFilter);
		if (files.length == 0) {
			System.out.println("Either dir does not exist or is not a directory");
		} else {
			for (int i = 0; i < files.length; i++) {
				File filename = files[i];
				Object DefaultMutableTreeNode;

				if (filename.toString().contains("$") || filename.toString().contains("Recovery")
						|| filename.toString().contains("System") || filename.toString().contains("Temp")
						|| filename.toString().contains("PerfLogs"))
					continue;
				else
					treeModel.insertNodeInto(new DefaultMutableTreeNode(filename.toString().substring(3)), root, 0);

			}
		}
		
		File[] files2;
		FileFilter fileFilter2=new FileFilter() {

			@Override
			public boolean accept(File file) {
				return file.isFile();
			}
		};
		files2=dir.listFiles(fileFilter2);
		
		for(int i=0;i<files2.length;i++) {

		}
		
		
		
	}

	public static void main(String[] args) {
		new FileManager();
	}
}
