public class WorldMap {
    private final int WSize = 8;

    private int[] playerPos = new int[2]; // playerPos[0] is row, playerPos[1] is col
    Space[][] worldMap;
    int[][] mapStructure = { // 0 is not accessible space, 1 is common space and 2 is market space.
            {0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,2,0},
            {0,2,1,2,0,0,0,0},
            {0,1,0,1,0,1,2,0},
            {0,1,0,1,0,1,0,0},
            {0,0,0,1,1,1,1,0},
            {0,1,1,1,1,2,1,0},
            {0,0,0,0,0,0,0,0}
    };

    WorldMap(){
        worldMap = new Space[WSize][WSize];

        playerPos[0] = 1;
        playerPos[1] = 1;

        // Start: Initialize the worldMap
        for(int i=0 ; i<WSize ; i++){
            for(int j=0 ; j<WSize ; j++){
                switch (mapStructure[i][j]){
                    case 0:
                        worldMap[i][j] = new InaccessSpace(0);
                        break;
                    case 1:
                        worldMap[i][j] = new CommonSpace(1);
                        break;
                    case 2:
                        worldMap[i][j] = new MarketSpace(2);
                        break;
                }
            }
        }
        // End: Initialize the worldMap
    }

    public boolean moveUp(){
        if(!isAccessible(playerPos[0]-1, playerPos[1])){
            System.out.println("Not accessible space!");
            return false;
        }
        playerPos[0]--;
        return true;
    }
    public boolean moveDown(){
        if(!isAccessible(playerPos[0]+1, playerPos[1])){
            System.out.println("Not accessible space!");
            return false;
        }
        playerPos[0]++;
        return true;
    }
    public boolean moveLeft(){
        if(!isAccessible(playerPos[0], playerPos[1]-1)){
            System.out.println("Not accessible space!");
            return false;
        }
        playerPos[1]--;
        return true;
    }
    public boolean moveRight(){
        if(!isAccessible(playerPos[0], playerPos[1]+1)){
            System.out.println("Not accessible space!");
            return false;
        }
        playerPos[1]++;
        return true;
    }

    public int typeOfCurrSpace(){
        return worldMap[playerPos[0]][playerPos[1]].getType();
    }

    public boolean isAccessible(int row, int col){
        return worldMap[row][col].isAccessible();
    }

    public void enterMarket(PartyOfHeroes ph){
        ((MarketSpace)worldMap[playerPos[0]][playerPos[1]]).getMarket().enterMarket(ph);
    }

    void show(){
        for(int i=0 ; i<WSize ; i++){
            for(int j=0 ; j<WSize ; j++){
                if(i == playerPos[0] && j == playerPos[1]){
                    System.out.print(String.format("%3s", "P"));
                }
                else{
                    System.out.print(String.format("%3s", worldMap[i][j].getSymbol()));
                }
            }
            System.out.println();
        }
    }
//    void show(){
//        int row = -1;
//        int col = 0;
//        Space[][] showedMap = new Space[WSize*2+1][WSize*2+1];
//        for(int i=0 ; i<showedMap.length ; i++){
//            for(int j=0 ; j<showedMap[i].length ; j++){
//                showedMap[i][j] = new Space();
//                if(i % 2 == 0){
//                    if(j % 2 == 0){
//                       showedMap[i][j].setSymbol(String.format("%3s", "+"));
//                    }
//                    else{
//                        showedMap[i][j].setSymbol(String.format("%3s", "--"));
//                    }
//                }
//                else{
//                    if(j % 2 == 0) {
//                        showedMap[i][j].setSymbol(String.format("%3s", "|"));
//                    }
//                    else{
//                        showedMap[i][j].setSymbol(String.format("%3s", worldMap[row][col % WSize].getSymbol()));
//                        col++;
//                    }
//                }
//                System.out.print(showedMap[i][j].getSymbol());
//            }
//            System.out.println();
//            if(i % 2 == 0){
//                row++;
//            }
//        }
//    }

}

class Space {
    private String symbol;
    private boolean accessibility;

    private int type;

    Space(int type){
        symbol = "";
        this.type = type;
        accessibility = true;
    }

    public int getType() {
        return type;
    }

    public boolean isAccessible(){
        return accessibility;
    }
    public String getSymbol(){
        return  symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setAccessibility(boolean accessibility){
        this.accessibility = accessibility;
    }
}

class CommonSpace extends Space{
    CommonSpace(int type){
        super(type);
        super.setSymbol(" ");
        super.setAccessibility(true);
    }
}

class InaccessSpace extends Space{
    InaccessSpace(int type){
        super(type);
        super.setSymbol("#");
        super.setAccessibility(false);
    }
}

class MarketSpace extends Space{
    private Market market;
    MarketSpace(int type){
        super(type);
        super.setSymbol("$");
        super.setAccessibility(true);
        market = new Market();
    }

    public Market getMarket() {
        return market;
    }
}

