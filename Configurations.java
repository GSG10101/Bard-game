public class Configurations {
    private int board_size;
    private int lengthToWin;
    private int max_levels;
    private char[][] board;
    
    public Configurations (int board_size, int lengthToWin, int max_levels){
        this.board_size = board_size;
        this.lengthToWin = lengthToWin;
        this.max_levels = max_levels;
        
        this.board = new char[board_size][board_size];
        for(int i =0; i < board_size;i++){
            for (int j =0; j < board_size;j++){
                board[i][j] = ' ';
            }
        }
    }
    public void Display() {
    	for(int i =0; i < board_size;i++){
            for (int j =0; j < board_size;j++){
               System.out.print(board[i][j]);}
            }
    }
    public static void main(String[] args) {
        
    }
    public HashDictionary createDictionary(){
        return new HashDictionary(6011);
    }
    
    public int repeatedConfiguration(HashDictionary hashTable){
    	String str ="";
    	
    	for(int i =0; i < board_size ;i++){
            for (int j =0; j <board_size;j++){
                str += board[i][j];
                }
            }
    	
    	if(hashTable.get(str) != -1) return hashTable.get(str);
    	else return -1;
    	
    }
    public void addConfiguration(HashDictionary hashDictionary, int score) {
    	String str ="";
    	
    	for(int i =0; i < board_size ;i++){
            for (int j =0; j < board_size;j++){
                str += board[0][0];
                }
            }
    	//System.out.println(str);
    	Data pair = new Data(str,score);
    	hashDictionary.put(pair);
    }

    public void savePlay(int row, int col, char symbol){
        board[row][col] = symbol;
    }
    public boolean squareIsEmpty (int row, int col) {
        if (board[row][col] == ' ') return true;
        return false;
    }

    public boolean wins (char symbol) {

        int count = 0;
        int centreTile_RowPos = 0;
        int centreTile_ColPos = 0;
        boolean flagX = checkforPlusShape(symbol);
        boolean flagPlus =  checkforXShape(symbol);

        if(flagX || flagPlus) {
          return true;

        }
        return false;
    }
    private boolean checkforXShape(char symbol) {
        int count = 0;
        for (int i = 1; i < board_size - 1; i++) {
            for (int j = 1; j < board_size - 1; j++) {
                if (board[i][j] == symbol) {
                    if (board[i - 1][j - 1] == symbol && board[i - 1][j + 1] == symbol && board[i + 1][j - 1] == symbol && board[i + 1][j + 1] == symbol){
                        count = 5;

                        if( count < lengthToWin ){
                            //Check For Diagonals to 2 Extended Place
                            if(i-2>=0 && j-2 >=0 && board[i-2][j-2] == symbol) count++;
                            if(i-2>=0 && j+2 < board_size && board[i-2][j+2] == symbol) count++;
                            if (i+2 < board_size && j-2>=0 & board[i+2][j-2] == symbol) count++;
                            if(i+2<board_size && j+2<board_size && board[i+2][j+2] == symbol)count++;
                        }
                        if( count < lengthToWin ){
                            //Check For Diagonals to 3 Extended Places
                            if(i-3>=0 && j-3 >=0 && board[i-3][j-3] == symbol) count++;
                            if(i-3>=0 && j+3 < board_size && board[i-3][j+3] == symbol) count++;
                            if (i+3 < board_size && j-3>=0 & board[i+3][j-3] == symbol) count++;
                            if(i+3<board_size && j+3<board_size && board[i+3][j+3] == symbol)count++;
                        }
                        if( count < lengthToWin ){
                            //Check For Diagonals to 4 Extended Places
                            if(i-4>=0 && j-4 >=0 && board[i-4][j-4] == symbol) count++;
                            if(i-4>=0 && j+4 < board_size && board[i-4][j+4] == symbol) count++;
                            if (i+4 < board_size && j-4>=0 && board[i+4][j-4] == symbol) count++;
                            if(i+4<board_size && j+4<board_size && board[i+4][j+4] == symbol)count++;
                        }

                        if( count < lengthToWin ){
                            //Check For Diagonals to 5 Extended Places
                            if(i-5>=0 && j-5 >=0 && board[i-5][j-5] == symbol) count++;
                            if(i-5>=0 && j+5 < board_size && board[i-5][j+5] == symbol) count++;
                            if (i+5 < board_size && j-5>=0 && board[i+5][j-5] == symbol) count++;
                            if(i+5<board_size && j+5<board_size && board[i+5][j+5] == symbol)count++;
                        }

                        if (count >= lengthToWin) return true;}
                }
            }
        }
        return false;
    }

    private boolean checkforPlusShape(char symbol){
        int count = 0;
        for (int i = 1; i < board_size - 1; i++) {
            for (int j = 1; j < board_size - 1; j++) {
                if (board[i][j] == symbol) {
                    if (board[i - 1][j] == symbol && board[i + 1][j] == symbol && board[i][j - 1] == symbol && board[i][j + 1] == symbol){
                        count = 5;
                        if (count < lengthToWin){
                            // Check for 2 Extended Places
                            if(i-2>=0 && board[i-2][j] == symbol) count++;
                            if(i+2 < board_size && board[i+2][j] == symbol) count++;
                            if(j-2>=0 && board[i][j-2] == symbol) count++;
                            if(j+2< board_size && board[i][j+2] == symbol) count++;
                        }

                        if (count < lengthToWin){
                            // Check for 3 Extended Places
                            if(i-3>=0 && board[i-3][j] == symbol) count++;
                            if(i+3< board_size && board[i+3][j] == symbol) count++;
                            if(j-3>=0 && board[i][j-3] == symbol) count++;
                            if(j+3< board_size && board[i][j+3] == symbol) count++;
                        }

                        if (count < lengthToWin){
                            // Check for 4 Extended Places
                            if(i-4>=0 && board[i-4][j] == symbol) count++;
                            if(i+4< board_size && board[i+4][j] == symbol) count++;
                            if(j-4>=0 && board[i][j-4] == symbol) count++;
                            if(j+4< board_size && board[i][j+4] == symbol) count++;
                        }

                        if (count < lengthToWin){
                            // Check for 5 Extended Places
                            if(i-5>=0 && board[i-5][j] == symbol) count++;
                            if(i+5< board_size && board[i+5][j] == symbol) count++;
                            if(j-5>=0 && board[i][j-5] == symbol) count++;
                            if(j+5< board_size && board[i][j+5] == symbol) count++;
                        }

                        if (count >= lengthToWin) return true;
                    }

                }
            }
        }
        return false;
    }




    public boolean isDraw() {
        boolean flag = true; // No empty spaces left
        for(int i =0; i < board_size ;i++){
            for (int j =0; j < board_size;j++){
                if(board[i][j] == ' ') flag = false;
            }
        }
		if(!wins('X' ) && !wins('O') && flag){
            return true;
        }
		return false;
	}
	public int evalBoard() {
		if (wins('O')) return 3;
        else if (wins('X')) return 0;
        else if (isDraw()) return 2;
        else   return 1;

	}


}
