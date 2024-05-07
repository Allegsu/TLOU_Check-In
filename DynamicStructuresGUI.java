import javax.swing.*;
import java.awt.event.*;

public class DynamicStructuresGUI extends JFrame implements ActionListener {
    private JButton stackPushBtn, stackScrollBtn, stackPopBtn, queueEnqueueBtn, queueLoopBtn, queueDequeueBtn, quitGameBtn;
    private JTextArea textArea;
    private Stack stack;
    private Queue queue;

    public DynamicStructuresGUI() {
        setTitle("Fireflies Data Base");
        setSize(400, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        //Set the Icon for the application 
        setIconImage(new ImageIcon("C:/Users/alleg/Desktop/Allegsu/School/Third Semester/EOP/P_9/images/fireflies.png").getImage());

        //Set bounds for the GUI in the center of the screen 
        setLocationRelativeTo(null);


        stack = new Stack();
        queue = new Queue();

        stackPushBtn = new JButton("Stack Push");
        stackPushBtn.setBounds(50, 30, 120, 30);
        stackPushBtn.addActionListener(this);
        add(stackPushBtn);

        stackScrollBtn = new JButton("Stack Scroll");
        stackScrollBtn.setBounds(50, 80, 120, 30);
        stackScrollBtn.addActionListener(this);
        add(stackScrollBtn);

        stackPopBtn = new JButton("Stack Pop");
        stackPopBtn.setBounds(50, 130, 120, 30);
        stackPopBtn.addActionListener(this);
        add(stackPopBtn);

        queueEnqueueBtn = new JButton("Queue Enqueue");
        queueEnqueueBtn.setBounds(200, 30, 120, 30);
        queueEnqueueBtn.addActionListener(this);
        add(queueEnqueueBtn);

        queueLoopBtn = new JButton("Queue Loop");
        queueLoopBtn.setBounds(200, 80, 120, 30);
        queueLoopBtn.addActionListener(this);
        add(queueLoopBtn);

        queueDequeueBtn = new JButton("Queue Dequeue");
        queueDequeueBtn.setBounds(200, 130, 120, 30);
        queueDequeueBtn.addActionListener(this);
        add(queueDequeueBtn);

        quitGameBtn = new JButton("Quit Game");
        quitGameBtn.setBounds(100,400,100,30);
        quitGameBtn.addActionListener(this);
        add(quitGameBtn);

        quitGameBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                System.exit(0);
            }
        });

        textArea = new JTextArea();
        textArea.setBounds(50, 180, 270, 50);
        add(textArea);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == stackPushBtn) {
            String input = JOptionPane.showInputDialog(this, "Enter a number to push onto the stack:");
            try {
                int num = Integer.parseInt(input);
                stack.push(num);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
            }
        } else if (e.getSource() == stackScrollBtn) {
            textArea.setText(stack.scroll());
        } else if (e.getSource() == stackPopBtn) {
            JOptionPane.showMessageDialog(this, stack.pop());
        } else if (e.getSource() == queueEnqueueBtn) {
            String input = JOptionPane.showInputDialog(this, "Enter a number to enqueue:");
            try {
                int num = Integer.parseInt(input);
                queue.enqueue(num);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter a number.");
            }
        } else if (e.getSource() == queueLoopBtn) {
            textArea.setText(queue.loop());
        } else if (e.getSource() == queueDequeueBtn) {
            JOptionPane.showMessageDialog(this, queue.dequeue());
        }
    }

    public static void main(String[] args) {
        new DynamicStructuresGUI();
    }

    private class Stack {
        private java.util.Stack<Integer> stack;

        public Stack() {
            stack = new java.util.Stack<>();
        }

        public void push(int num) {
            stack.push(num);
        }

        public String scroll() {
            if (stack.isEmpty()) {
                return "Stack is empty";
            }
            return stack.toString();
        }

        public String pop() {
            if (stack.isEmpty()) {
                return "Stack is empty";
            }
            return "Popped: " + stack.pop();
        }
    }

    private class Queue {
        private java.util.Queue<Integer> queue;

        public Queue() {
            queue = new java.util.LinkedList<>();
        }

        public void enqueue(int num) {
            queue.add(num);
        }

        public String loop() {
            if (queue.isEmpty()) {
                return "Queue is empty";
            }
            return queue.toString();
        }

        public String dequeue() {
            if (queue.isEmpty()) {
                return "Queue is empty";
            }
            return "Dequeued: " + queue.poll();
        }
    }
}

