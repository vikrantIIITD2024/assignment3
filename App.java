import java.util.ArrayList;

import java.util.Scanner;


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
            res[i][j]=a[i][j]+b[i][j];    //use - for subtraction  
            System.out.print(res[i][j]+" ");    
            }    
            System.out.println();//new line    
            }     
        

        return null;
    }

    public Matrix sub(Matrix matrix){
        Scanner in = new Scanner(System.in);
        int mat1[][] = new int[2][2];
        int mat2[][] = new int[2][2];
        int sub[][] = new int[2][2];
        int i,j;
        for (i = 0; i < 2; i++)
        {
        for (j = 0; j < 2; j++)
        {
        mat1[i][j] = in.nextInt();
        mat2[i][j] = in.nextInt();
        sub[i][j]=mat1[i][j]-mat2[i][j];
        }
        }
        for (i = 0; i < 2; i++)
        {
        for (j = 0; j < 2; j++)
        {
        System.out.print(sub[i][j]+"\t");
        }
        System.out.println();
        }

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

    
    public Matrix inverse(){
        //implement the code here

       
        float det, temp;
        float mat[][] = new float[2][2];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements of matrix row wise:");
        for(int i = 0; i < 2; ++i)
        for(int j = 0; j < 2; ++j)
        mat[i][j] = sc.nextFloat();
        det = (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]);
        System.out.println("\ndeterminant = " + det);
        temp = mat[0][0];
        mat[0][0] = mat[1][1];
        mat[1][1] = temp;
        mat[0][1] = - mat[0][1];
        mat[1][0] = - mat[1][0];
        System.out.println("\nInverse of matrix is:");
        for(int i = 0; i < 2; ++i) {
        for(int j = 0; j < 2; ++j)
        System.out.print((mat[i][j]/det) + " ");
        System.out.print("\n");
    }

        return null;
    }

    public int getDeterminant(){
        //implement code here
        float det, temp;
        float mat[][] = new float[2][2];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements of matrix row wise:");
        for(int i = 0; i < 2; ++i)
        for(int j = 0; j < 2; ++j)
        mat[i][j] = sc.nextFloat();
        det = (mat[0][0] * mat[1][1]) - (mat[0][1] * mat[1][0]);
        System.out.println("\nDeterminant = " + det);

        return 0;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
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
        System.out.println("1. To Add Matrix: ");
        System.out.println("2. Matrix Type: ");
        System.out.println("3. Find inverse by using ID: "); 
        System.out.println("4. Add two Matrix by using ID: ");
        System.out.println("5. Subtract two Matrix by using ID: ");
        System.out.println("6. Multiply two Matrix by using ID: ");
        System.out.println("7. Divide two Matrix by using ID: ");
        System.out.println("8. Elements wise operation by using ID: ");
        System.out.println("9. Find Transpose of Matrix by using ID: ");
        System.out.println("10. ");

        Scanner s = new Scanner(System.in);
        String answer = "y";
        //int input = s.nextInt();
        while (answer.equals(answer)) {
            System.out.println("Want to add Matrix?");
            answer = s.next();

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

            
            System.out.println("Test multiplication");
            System.out.println("Enter the first Matrix ID:");
            String id1 =  s.next();
            System.out.println("Enter second Matrix ID:");
            String id2 = s.next();

            Matrix m1 = getMatrixByID(mat, id1);
            Matrix m2 = getMatrixByID(mat, id2);

            m1.multiply(m2);
            
            
        
    }
}
