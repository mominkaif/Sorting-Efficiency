/*
 * Kaif Momin
 * May 04, 2022
 * This program allows the user to compare the efficiency to three different sorting algorithms. 
 * Sorting algorithms used: Selection sort, Bubble sort, Quick sort
 */
package measuringsortingmethods;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.ButtonModel;

/**
 *
 * @author kaifm
 */
public class MeasuringSortingMethods extends javax.swing.JFrame {

    private int[] tenNums;
    private int[] tenThousandNums;
    //will store the number of times a loop was executed
    private int loop = 0;

    /**
     * Creates new form MominSortingEfficiencies
     */
    public MeasuringSortingMethods() {
        initComponents();
        tenNums = new int[10];
        tenThousandNums = new int[10000];
        readData();
    }

    /**
     * This method reads the two integer files and stores them in their
     * respective arrays
     *
     * @param tenNums - tenNums array
     * @param tenThousandNums - tenThousandNums array
     */
    private void readData() {
        //try catch to read the file and store the integers into an array
        try {
            File f = new File("src/measuringsortingmethods/10nums.txt");
            Scanner s = new Scanner(f);
            for (int i = 0; i < 10; i++) {
                tenNums[i] = Integer.parseInt(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR! " + e);
        }

        try {
            File f1 = new File("src/measuringsortingmethods/10000nums.txt");
            Scanner s1 = new Scanner(f1);
            for (int i = 0; i < 10000; i++) {
                tenThousandNums[i] = Integer.parseInt(s1.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR! " + e);
        }
    }

    /**
     * selection sort method, ascending
     *
     * @param order - determines if the sort will be ascending or descending
     * @param n - number of items in the original array
     * @param r - unsorted array
     * @return - returns a sorted array
     */
    private int[] asSelectionSort(int n, int[] r) {
        int temp; //stores a temporary value
        int[] a = new int[n]; //new array that will be sorted

        //load all the values from the unsorted array
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }

        //i represents the first number being compared
        for (int i = 0; i < n - 1; i++) {
            //j represents the second number being compared
            for (int j = i + 1; j < n; j++) {
                //update the loop variable by adding one
                loop += 1;
                //if the first number is bigger than the second, switch them
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        return a; //return sorted array
    }

    /**
     * selection sort method, descending
     *
     * @param order - determines if the sort will be ascending or descending
     * @param n - number of items in the original array
     * @param r - unsorted array
     * @return - returns a sorted array
     */
    private int[] deSelectionSort(int n, int[] r) {
        int temp; //stores a temporary value
        int[] a = new int[n]; //new array that will be sorted

        //load all the values from the unsorted array
        for (int i = 0; i < n; i++) {
            a[i] = r[i];
        }

        //i represents the first number being compared
        for (int i = 0; i < n - 1; i++) {
            //j represents the second number being compared
            for (int j = i + 1; j < n; j++) {
                //update the loop variable by adding one
                loop += 1;
                //if the first number is bigger than the second, switch them
                if (a[i] < a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

        return a; //return sorted array
    }

    /**
     * bubble sort method, ascending
     *
     * @param order - determines if the sort will be ascending or descending
     * @param n - number of items in the original array
     * @param a - unsorted array
     * @return - sorted array
     */
    private int[] asBubbleSort(int n, int[] a) {
        int bottom = a.length - 1;
        boolean sw = true;
        int temp;
        int[] r = new int[n];
        
        for (int i = 0; i < n; i++) {
            r[i] = a[i];
        }
        while (sw) {
            sw = false;
            for (int j = 0; j < bottom; j++) {
                //update the loop variable by adding one
                loop += 1;
                if (r[j] > r[j + 1]) {
                    temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                    sw = true;
                }
            }
            bottom = bottom - 1;
        }
        return r;
    }

    /**
     * bubble sort method, descending
     *
     * @param order - determines if the sort will be ascending or descending
     * @param n - number of items in the original array
     * @param a - unsorted array
     * @return - sorted array
     */
    private int[] deBubbleSort(int n, int[] a) {
        int bottom = a.length - 1;
        boolean sw = true;
        int temp;
        int[] r = new int[n];

        for (int i = 0; i < n; i++) {
            r[i] = a[i];
        }
        while (sw) {
            sw = false;
            for (int j = 0; j < bottom; j++) {
                //update the loop variable by adding one
                loop += 1;
                if (r[j] < r[j + 1]) {
                    temp = r[j];
                    r[j] = r[j + 1];
                    r[j + 1] = temp;
                    sw = true;
                }
            }
            bottom = bottom - 1;
        }
        return r;
    }

    /**
     * quick sort method, ascending
     *
     * @param a
     * @param left
     * @param right
     * @param order
     */
    private void asQuickSort(int[] a, int left, int right) {
        int temp = 0;
        int i = 0;
        int j = 0;
        int pivot = 0;

        if (left >= right) {
            return;
        }
        i = left;
        j = right;
        pivot = a[(left + right) / 2];

        while (i < j) {
            while (a[i] < pivot) {
                i++;
                //update the loop variable by adding one
                loop += 1;
            }
            while (pivot < a[j]) {
                j--;
                //update the loop variable by adding one
                loop += 1;
            }
            if (i <= j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        asQuickSort(a, left, j);
        asQuickSort(a, i, right);
    }

    /**
     * quick sort method, descending
     *
     * @param a
     * @param left
     * @param right
     */
    private void deQuickSort(int[] a, int left, int right) {
        int temp = 0;
        int i = 0;
        int j = 0;
        int pivot = 0;

        if (left >= right) {
            return;
        }
        i = left;
        j = right;
        pivot = a[(left + right) / 2];

        while (i < j) {
            while (a[i] > pivot) {
                i++;
                //update the loop variable by adding one
                loop += 1;
            }
            while (pivot > a[j]) {
                j--;
                //update the loop variable by adding one
                loop += 1;
            }
            if (i <= j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        deQuickSort(a, left, j);
        deQuickSort(a, i, right);
    }

    /**
     * this method will sort the array all three ways and record time taken and
     * number of loops
     *
     * @param array - the unsorted array
     * @param size - size of the array
     * @param left - left index for quick sort
     * @param right - right index for quick sort
     * @param order - ascending or descending
     */
    private void sortComparison(int[] array, int size, int left, int right) {
        //will store the output
        String output = "";
        //start time
        long start;
        //end time
        long end;
        //time taken
        long tTaken;

        //if user wants to sort in an ascending manner
        if (ascending.isSelected()) {
            loop = 0; //restart the loop
            start = System.nanoTime();
            //sort the array using selection sort
            asSelectionSort(size, array);
            end = System.nanoTime();
            tTaken = end - start;
            //update output string
            output = output + "Selection Sort:\n" + "Number of times a loop was executed: " + loop + "\nNumber of nanoseconds to complete: " + tTaken;

            loop = 0; //restart the loop
            start = System.nanoTime();
            //sort the array using bubble sort
            asBubbleSort(size, array);
            end = System.nanoTime();
            tTaken = end - start;
            //update output string
            output = output + "\n\nBubble Sort:\n" + "Number of times a loop was executed: " + loop + "\nNumber of nanoseconds to complete: " + tTaken;

            loop = 0; //restart the loop
            start = System.nanoTime();
            //sort the array using quick sort
            asQuickSort(array, left, right);
            end = System.nanoTime();
            tTaken = end - start;
            //update output string
            output = output + "\n\nQuick Sort:\n" + "Number of times a loop was executed: " + loop + "\nNumber of nanoseconds to complete: " + tTaken;
        } else if (descending.isSelected()) { //if user wants to sort in an ascending manner
            loop = 0; //restart the loop
            start = System.nanoTime();
            //sort the array using selection sort
            deSelectionSort(size, array);
            end = System.nanoTime();
            tTaken = end - start;
            //update output string
            output = output + "Selection Sort:\n" + "Number of times a loop was executed: " + loop + "\nNumber of nanoseconds to complete: " + tTaken;

            loop = 0; //restart the loop
            start = System.nanoTime();
            //sort the array using bubble sort
            deBubbleSort(size, array);
            end = System.nanoTime();
            tTaken = end - start;
            //update output string
            output = output + "\n\nBubble Sort:\n" + "Number of times a loop was executed: " + loop + "\nNumber of nanoseconds to complete: " + tTaken;

            loop = 0; //restart the loop
            start = System.nanoTime();
            //sort the array using quick sort
            deQuickSort(array, left, right);
            end = System.nanoTime();
            tTaken = end - start;
            //update output string
            output = output + "\n\nQuick Sort:\n" + "Number of times a loop was executed: " + loop + "\nNumber of nanoseconds to complete: " + tTaken;
        }

        //output the information in the results section
        comparison.setText(output);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ten = new javax.swing.JRadioButton();
        tenThousand = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        ascending = new javax.swing.JRadioButton();
        descending = new javax.swing.JRadioButton();
        sort = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ogNums = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        sortedNums = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        comparison = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 205, 25));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(0, 205, 255));

        jLabel1.setFont(new java.awt.Font("Wide Latin", 0, 18)); // NOI18N
        jLabel1.setText("Sorting Efficiencies");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Amount of numbers to sort: ");

        ten.setBackground(new java.awt.Color(0, 205, 255));
        buttonGroup1.add(ten);
        ten.setSelected(true);
        ten.setText("10");

        tenThousand.setBackground(new java.awt.Color(0, 205, 255));
        buttonGroup1.add(tenThousand);
        tenThousand.setText("10,000");
        tenThousand.setToolTipText("");
        tenThousand.setBorderPainted(true);
        tenThousand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tenThousandActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Display numbers sorted by: ");

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selection Sort", "Bubble Sort", "Quick Sort" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sort Order: ");

        ascending.setBackground(new java.awt.Color(0, 205, 255));
        buttonGroup4.add(ascending);
        ascending.setText("Ascending");

        descending.setBackground(new java.awt.Color(0, 205, 255));
        buttonGroup4.add(descending);
        descending.setText("Descending");

        sort.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        sort.setText("SORT");
        sort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Original Numbers: ");

        ogNums.setColumns(20);
        ogNums.setRows(5);
        jScrollPane1.setViewportView(ogNums);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Sorted Numbers: ");

        sortedNums.setColumns(20);
        sortedNums.setRows(5);
        jScrollPane2.setViewportView(sortedNums);

        comparison.setColumns(20);
        comparison.setRows(5);
        jScrollPane3.setViewportView(comparison);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Sorting Results: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(descending)
                                    .addComponent(ascending))))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sort, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ten)
                                .addGap(18, 18, 18)
                                .addComponent(tenThousand)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 116, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(ten)
                    .addComponent(tenThousand))
                .addGap(1, 1, 1)
                .addComponent(jLabel7)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(ascending))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(descending))
                            .addComponent(sort, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void tenThousandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tenThousandActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tenThousandActionPerformed

    private void sortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortActionPerformed

        //String that will store the numbers as is
        String ogNumbers = " ";
        //String that will store the numbers after they are sorted
        String sortedNumbers = " ";
        //String that will store the users sorting method selection
        String sortMethod = type.getSelectedItem().toString();
        //array that will contain 10 sorted numbers
        int[] sortedTen = new int[10];
        //array that will contain 10000 sorted numbers
        int[] sortedTenK = new int[10000];

        //temporary copies of the original arrays 
        //will be used for quick sort 
        int[] r = new int[10];
        for (int d = 0; d < 10; d++) {
            r[d] = tenNums[d];
        }
        int[] s = new int[10000];
        for (int o = 0; o < 10000; o++) {
            s[o] = tenThousandNums[o];
        }

        if (ten.isSelected()) { //if user wants 10 numbers
            //loads the ogNumbers String with the unsorted numbers
            for (int i = 0; i < 10; i++) {
                //add the next index plus the next number in a new line to the ogNumbers
                ogNumbers = ogNumbers + i + ".  " + tenNums[i] + "\n";
            }

            if (ascending.isSelected()) { //if user wants to sort in an ascending manner
                if (sortMethod.equals("Selection Sort")) {
                    //calls selection sort method
                    sortedTen = asSelectionSort(10, tenNums);
                } else if (sortMethod.equals("Bubble Sort")) { //if user chooses Bubble sort option
                    //calls bubble sort method
                    sortedTen = asBubbleSort(10, tenNums);

                } else if (sortMethod.equals("Quick Sort")) {//if user chooses Quick sort option
                    //call the bubble sort method, 1 will tell it to ascend
                    asQuickSort(r, 0, 9); //send the temporary array to be sorted
                    sortedTen = r; //set the sortedTen array to the sorted temp array
                }
            } else if (descending.isSelected()) { //if user wants to sort in an descending manner
                if (sortMethod.equals("Selection Sort")) {
                    //calls selection sort method
                    sortedTen = deSelectionSort(10, tenNums);
                } else if (sortMethod.equals("Bubble Sort")) { //if user chooses Bubble sort option
                    //calls selection bubble method
                    sortedTen = deBubbleSort(10, tenNums);
                } else if (sortMethod.equals("Quick Sort")) {//if user chooses Quick sort option
                    //call the bubble sort method, -1 will tell it to descend
                    deQuickSort(r, 0, 9); //send the temporary array to be sorted
                    sortedTen = r; //set the sortedTen array to the sorted temp array
                }
            }

            //loads the sortedNumbers String with the sorted numbers
            for (int d = 0; d < 10; d++) {
                //add the next index plus the next sorted number in a new line to the sortedNumbers
                sortedNumbers = sortedNumbers + d + ".  " + sortedTen[d] + "\n";
            }

            //call the sortComparison method
            sortComparison(tenNums, 10, 0, 9);
        } else if (tenThousand.isSelected()) {  //if user wants 10000 numbers
            //load the ogNumbers String with the unsorted numbers
            for (int i = 0; i < tenThousandNums.length; i++) {
                //add the next index plus the next number in a new line to the ogNumbers
                ogNumbers = ogNumbers + i + ".  " + tenThousandNums[i] + "\n";
            }

            if (ascending.isSelected()) { //if user wants to sort in an ascending manner
                if (sortMethod.equals("Selection Sort")) {
                    sortedTenK = asSelectionSort(10000, tenThousandNums);
                } else if (sortMethod.equals("Bubble Sort")) { //if user chooses Bubble sort option
                    sortedTenK = asBubbleSort(10000, tenThousandNums);

                } else if (sortMethod.equals("Quick Sort")) {//if user chooses Quick sort option
                    //call the bubble sort method, 1 will tell it to ascend
                    asQuickSort(s, 0, 9999); //send the temporary array to be sorted
                    sortedTenK = s; //set the sortedTen array to the sorted temp array
                }
            } else if (descending.isSelected()) { //if user wants to sort in an descending manner
                if (sortMethod.equals("Selection Sort")) {
                    //call the seclection sort method, -1 will tell it to descend
                    sortedTenK = deSelectionSort(10000, tenThousandNums);
                } else if (sortMethod.equals("Bubble Sort")) { //if user chooses Bubble sort option
                    sortedTenK = deBubbleSort(10000, tenThousandNums);
                } else if (sortMethod.equals("Quick Sort")) {//if user chooses Quick sort option
                    //call the bubble sort method, -1 will tell it to descend
                    deQuickSort(s, 0, 9999); //send the temporary array to be sorted
                    sortedTenK = s; //set the sortedTen array to the sorted temp array
                }
            }
            //loads the sortedNumbbers String with the sorted values
            for (int k = 0; k < 10000; k++) {
                sortedNumbers = sortedNumbers + k + ".  " + sortedTenK[k] + "\n";
            }

            //call the sortComparison method
            sortComparison(tenThousandNums, 10000, 0, 9999);
        }

        //print the unsorted numbers in the respective textArea
        ogNums.setText(ogNumbers);
        //print the unsorted numbers in the respective textArea
        sortedNums.setText(sortedNumbers);

    }//GEN-LAST:event_sortActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MeasuringSortingMethods.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MeasuringSortingMethods.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MeasuringSortingMethods.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MeasuringSortingMethods.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MeasuringSortingMethods().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ascending;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JTextArea comparison;
    private javax.swing.JRadioButton descending;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea ogNums;
    private javax.swing.JButton sort;
    private javax.swing.JTextArea sortedNums;
    private javax.swing.JRadioButton ten;
    private javax.swing.JRadioButton tenThousand;
    private javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables

}
