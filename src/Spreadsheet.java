
public class Spreadsheet {
  
  // private fields
  private Cell[][] cells;
  private static int rows=11;
  private static int cols=8;
  private static int colWidth=12;
  private static int asciiOffset=64;
  private String border;
  private String borderRow;
  
  // private methods
  private static int getCol(String location) {
    return location.charAt(0)-asciiOffset;
  }
  
  private static int getRow(String location) {
    return Integer.parseInt(location.substring(1));
  }
  
  private static String padOrTruncateDisplayString(Cell cell) {
    // truncate string to length - 1 and display >
    String s = cell.getDisplayString();
    if (s.length() > colWidth) {
      s = s.substring(0, colWidth - 1) + ">";
    }
    // if length is odd pad end to even length
    if (s.length() % 2 == 1) {
      s += " ";
    }
    // justify pad to center in cell
    while (s.length() < colWidth) {
      s = " " + s + " ";
    }
    return s;
  }
  
  // constructor
  public Spreadsheet() {
    cells = new Cell[rows][cols];
    cells[0][0]= new CellString("");
    border="";
    for(int i=0; i<colWidth;i++)
    {
      border+="-";
    }
    borderRow= border+"+";
    
    for(int col=1;col<cols;col++)
    {
      cells[0][col]= new CellString((char)(asciiOffset+col)+"");
      borderRow+=border+"+";
    }
    for(int row=1; row<rows; row++)
    {
      cells[row][0] = new CellNumeric(row+"");
      for(int col=1; col<cols;col++)
      {
        cells[row][col]= new CellString("");
      }
    }
  }
  
  
  
  // mutators
  public void setCell(String location, Cell cell) {
    int c=   getCol(location);
    int r =getRow(location);
    cells[r][c]=cell;
    
  }
  
  
  // accessors
  public Cell getCell(String location) {
    return cells[ location.charAt(0)-asciiOffset][ Integer.parseInt(location.substring(1))];
  }
  
  public void print() {
    
    
    for(int r =0;r<rows;r++)
    {
      for(int c=0;c<cols;c++)
      {
        
        System.out.print(padOrTruncateDisplayString(cells[r][c])+"|");
        
      }
      System.out.println();
      System.out.println(borderRow); 
    }
  }
  
}

