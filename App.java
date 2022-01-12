import java.util.ArrayList;

import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;
import javax.swing.plaf.synth.SynthOptionPaneUI;


class Matrix{

    private int n;
    private int m;
    protected int[][] elements = new int[n][m];
    private String id;

    public Matrix(String id, int n, int m){
        this.id = id;
        this.n = n;
        this.m = m;
    }

    public String getId() {
        return id;
    }

    public Matrix add(Matrix matrix){
        int[][] b = matrix.getElements();
        int[][] a = this.getElements();
        int[][] res = new int[n][m];
        for(int i=0;i<n;i++){    
            for(int j=0;j<m;j++){    
            res[i][j]=a[i][j]+b[i][j];      
            System.out.print(res[i][j]+" ");    
            }    
            System.out.println();//new line    
            }     
        

        return null;
    }

    public Matrix sub(Matrix matrix){
        
        int[][] b = matrix.getElements();
        int[][] a = this.getElements();
        int[][] res = new int[n][m];
        for(int i=0;i<n;i++){    
            for(int j=0;j<m;j++){    
            res[i][j]=a[i][j]-b[i][j];  
            System.out.print(res[i][j]+" ");    
            }    
            System.out.println();//new line    
            }     

        return null;
    }

    public Matrix div(Matrix matrix){
        int array[][]=matrix.getElements();
        int array1[][]=this.getElements();
        
        System.out.println("First matrix is:" + " " );
        for(int i=0; i< this.n; i++){
        for (int j=0; j<this.m; j++)
        {
        System.out.print(" " +array[i][j]);
        }
        System.out.println();
        }
        
        System.out.println("Second matrix is:"+ " ");
        for (int i=0; i< this.n; i++){
        for(int j=0; j<this.m; j++){
        System.out.print(" " + array1[i][j]);
        }
        System.out.println();
        }
        System.out.println("Divide of both matrix : ");
        for(int i = 0; i < this.n; i++) {
        for(int j = 0; j < this.m; j++) {
        System.out.print(" "+(array[i][j]/array1[i][j]));
        }
        System.out.println(" ");
        }
        return null;
    }
    
    public Matrix multiply(Matrix matrix){

        int[][] b = matrix.getElements();
        int[][] a = this.getElements();
        int[][] res = new int[n][m];
        //Matrix _resMat
        for(int i =0; i<n;i++){
            for(int j = 0; j<m; j++){
                res[i][j] =0;
                for(int k=0; k<m;k++){
                    res[i][j] += a[i][k]*b[k][j];
                }
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

        
        
        return null;
    }

    public int getDimension(){
        return this.n * this.m;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }
    public Matrix transpose(Matrix matrix){
        //implement the code here
        
        
        return null;
    }
    public void setElements(int[][] elements) {
        this.elements = elements;
    }
    @Override
    public String toString() {
        return "The matrix is of ";
    }

    public void formattedPrint(){
        for (int i = 0; i < this.n; i++ ) {
            for (int j = 0; j < this.m;j++)
                System.out.print(this.elements[i][j] + "  ");
            System.out.println();
        }
    }

    public int[][] getElements() {
        return elements;
    }
}



class ColumnMatrix extends Matrix {
    public ColumnMatrix(String id, int m){
        super(id, 1, m);
    }

    @Override
    public String toString() {
        
        return super.toString() + "Column type";
    }
}


class RowMatrix extends Matrix {
    public RowMatrix(String id, int n){
        super(id, n, 1);
    }
    @Override
    public String toString() {
  
        return super.toString() + "Row type";
    }
}



class SquareMatrix extends Matrix{ 
    
    public SquareMatrix(String id, int n){
        super(id, n,n);
    }

    
    public void inverse(){
        //implement the code here

       
        float det, temp;
        int mat[][] = super.getElements();

        //for square 2x2 matrix
        
       if (super.getN() == super.getM() && super.getN() == 2) {
        
            det = this.getDeterminant();
            temp = mat[0][0];
            mat[0][0] = mat[1][1];
            mat[1][1] = (int)temp;
            mat[0][1] = - mat[0][1];
            mat[1][0] = - mat[1][0];

            System.out.println("\nInverse of matrix is:");
            for(int i = 0; i < super.getN(); ++i) {
            for(int j = 0; j < super.getM(); ++j)
            System.out.print((mat[i][j]/det) + " ");
            System.out.print("\n");
       } 
    }

    }
    public void transpose(){
        int mat1[][] = super.getElements();
        int transpose[][]=new int[super.getM()][super.getN()];  //3 rows and 3 columns  
            
        //Code to transpose a matrix  
        for(int i=0;i<super.getN();i++){    
        for(int j=0;j<super.getM();j++){    
        transpose[i][j]=mat1[j][i];  
        }    
        }    
        
            
        System.out.println("Required Transpose:");  
        for(int i=0;i<super.getN();i++){    
        for(int j=0;j<super.getM();j++){    
        System.out.print(transpose[i][j]+" ");    
        }    
        System.out.println();//new line    
        } 
        
        
    }
    // public void sum_transpose(){
    //     int[][] b = transpose();
    //     int[][] a = this.getElements();
    //     int[][] res = new int[super.getN()][super.getM()];
    //     for(int i=0;i<super.getN();i++){    
    //         for(int j=0;j<super.getM();j++){    
    //         res[i][j]=a[i][j]+b[i][j];      
    //         System.out.print(res[i][j]+" ");    
    //         }    
    //         System.out.println();//new line    
    //         }     
        

        
        
    // }

    public int getDeterminant(){
        //implement code here
       
        return  (super.getN() == 2 && super.getM() == 2) ? (super.getElements()[0][0] * super.getElements()[1][1]) - (super.getElements()[0][1] * super.getElements()[1][0]): 0;
    }

    @Override
    public String toString() {
     
        return super.toString() + "Square type";
    }
}


class RectangularMatrix extends Matrix {
    public RectangularMatrix(String id, int n, int m) {
        super(id, n, m);
    }
}



public class App {

    public static Matrix getMatrixByID(ArrayList<Matrix> matrixs, String id) {
        for (Matrix m: matrixs){
            if (m.getId().equals(id)) {
                return m;
            }
        }
        return null;
    }
    public static void main(String[] args) throws Exception {
        
        ArrayList<Matrix> mat = new ArrayList<Matrix>();
        int choice=0;
        
        while(choice!=12){
    
        System.out.println("");
        System.out.println("---------------Welcome to Matrix Calculator---------------");
        System.out.println("1. To Add Matrix in a List ");
        System.out.println("2. Matrix Type by ID");
        System.out.println("3. Find inverse by using ID "); 
        System.out.println("4. Add two Matrix by using ID ");
        System.out.println("5. Subtract two Matrix by using ID ");
        System.out.println("6. Multiply two Matrix by using ID ");
        System.out.println("7. Divide two Matrix by using ID ");
        System.out.println("8. Elements wise operation by using ID ");
        System.out.println("9. Find Transpose of Matrix by using ID ");
        System.out.println("10.Find determinant of Matrix using ID ");
        System.out.println("11.Find A+AT using ID ");
        System.out.println("12.Exit");
        System.out.println("------------------------*************---------------------");
        System.out.println("Select Serial Number to proceed further :)");
        System.out.println("------------------------*************---------------------");

        Scanner s = new Scanner(System.in);
        choice = s.nextInt();
        if(choice == 1){
        String answer = "yes";
       
        while (answer.equals(answer)) {
            System.out.println("Want to add Matrix?");
            answer = s.next();
            if(!answer.equals("yes")){
                break;
            }
            System.out.println("Enter Matrix ID: ");
            String _id = s.next();
            System.out.println("Enter the number of rows");
            int row = s.nextInt();
            System.out.println("Enter the number columns");
            int col = s.nextInt();
            
            int matrix[][] = new int[row][col];
            //int length = row * col;
            
            System.out.println("Enter the elements: \n");
            for (int i = 0; i < row; i++ ) {
                for (int j = 0; j < col; j++){
                    matrix[i][j] = s.nextInt();
                }
            }
            //implement here

            if (row == col) {
                SquareMatrix squareMatrix = new SquareMatrix(_id, col);
                squareMatrix.setElements(matrix);
                mat.add(squareMatrix);
            }
            else if(row != col){

                RectangularMatrix rectangularMatrix = new RectangularMatrix(_id, row, col);
                rectangularMatrix.setElements(matrix);
                mat.add(rectangularMatrix);
                
            }

        }

        }
        if(choice == 2) {
            System.out.println("Enter ID of the matrix");
            int a = s.nextInt();
            System.out.println(mat.get(a-1));
            System.out.println(" ");
        }

        if (choice == 3) {
            System.out.println("Enter ID of the matrix");
            String id = s.next();
            Matrix matrix = getMatrixByID(mat, id);
            if (matrix instanceof SquareMatrix square) {
                square.inverse();
            } else {
                System.out.println("Matrix must be square");
            }

        }
        
        if (choice ==4){
            System.out.println("Enter the first Matrix ID:");
            String id1 =  s.next();
            System.out.println("Enter second Matrix ID:");
            String id2 = s.next();
            Matrix m1 = getMatrixByID(mat, id1);
            Matrix m2 = getMatrixByID(mat, id2);
            m1.add(m2);
        }
        if(choice == 5){
            System.out.println("Enter the first Matrix ID:");
            String id1 =  s.next();
            System.out.println("Enter second Matrix ID:");
            String id2 = s.next();
            Matrix m1 = getMatrixByID(mat, id1);
            Matrix m2 = getMatrixByID(mat, id2);
            m1.sub(m2);
        }
        if(choice == 6){
            System.out.println("Enter the first Matrix ID:");
            String id1 =  s.next();
            System.out.println("Enter second Matrix ID:");
            String id2 = s.next();

            Matrix m1 = getMatrixByID(mat, id1);
            Matrix m2 = getMatrixByID(mat, id2);

            m1.multiply(m2);
        }
        if(choice==7){
            System.out.println("Enter the first Matrix ID:");
            String id1 =  s.next();
            System.out.println("Enter second Matrix ID:");
            String id2 = s.next();
            Matrix m1 = getMatrixByID(mat, id1);
            Matrix m2 = getMatrixByID(mat, id2);
            m1.div(m2);
        }
        if(choice == 9){
            System.out.println("Enter ID of the matrix");
            String id = s.next();
            Matrix matrix = getMatrixByID(mat, id);
            if (matrix instanceof SquareMatrix square) {
                square.transpose();
            } else {
                System.out.println("Not possible");
            }
        
            

        }
        if (choice == 10) {
            System.out.println("Enter Matrix ID:");
            String id = s.next();
            Matrix matrix = getMatrixByID(mat, id);
            if (matrix instanceof SquareMatrix square) {
               System.out.println("Determinant = " + square.getDeterminant());

            }
        }
 
        
    }
    
}
