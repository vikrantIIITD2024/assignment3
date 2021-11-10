import java.util.ArrayList;

import java.util.Scanner;

class Matrix{

    private int n;
    private int m;
    protected int[][] elements = new int[n][m];

    public Matrix(int n, int m){
        this.n = n;
        this.m = m;
    }


    public Matrix add(Matrix matrix){
        return null;
    }

    public Matrix sub(Matrix matrix){
        return null;
    }

    public Matrix div(Matrix matrix){
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
    public Matrix transpose(){
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
    public ColumnMatrix(int m){
        super(1, m);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + "Column type";
    }
}


class RowMatrix extends Matrix {
    public RowMatrix(int n){
        super(n, 1);
    }
    @Override
    public String toString() {
  
        return super.toString() + "Row type";
    }
}



class SquareMatrix extends Matrix{ 
    
    public SquareMatrix(int n){
        super(n,n);
    }

    
    public Matrix inverse(){
        //implement the code here

        return null;
    }

    public int getDeterminant(){
        //implement code here
        return 0;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + "Square type";
    }
}


class RectangularMatrix extends Matrix {
    public RectangularMatrix(int n, int m) {
        super(n, m);
    }
}

/* class SingularMatrix extends SquareMatrix {
    public SingularMatrix(int n){
        super(n);
    }
}

class NullMatrix extends SingularMatrix {
    public NullMatrix(int n){
        super(n);
    }
} */


public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Matrix> mat = new ArrayList<Matrix>();
        // HashMap<String, Matrix> matrices = new HashMap<>();


        Scanner s = new Scanner(System.in);
        //int input = s.nextInt();
    
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
            SquareMatrix squareMatrix = new SquareMatrix(col);
            squareMatrix.setElements(matrix);
            mat.add(squareMatrix);
        }
        else if(row != col){
            RectangularMatrix rectangularMatrix = new RectangularMatrix(row, col);
            rectangularMatrix.setElements(matrix);
            mat.add(rectangularMatrix);
        }


        //print all matrices
        for (Matrix m: mat){
            m.formattedPrint();
            m.toString();

        }

        s.close();
    }
}
