package ca.bcit.comp2526.a2a;

public enum SpawnType {
    PLANT     (0,  3),
    HERBIVORE (3,  4), 
    CARNIVORE (5,  -1),
    BLANK     (0,  -1);
    
    private static final int spawnPool = 9;
    private final int spawnMin;
    private final int spawnMax;
    
    SpawnType(int min, int max){
        spawnMin = min;
        spawnMax = max;
    }
    
    private boolean inbounds(int r){
        if(r >= spawnMin && r < spawnMax)
            return true;
        return false;
    }
    
    
    public static SpawnType spawn(){
        int rand = RandomGenerator.nextNumber(spawnPool);
        for(SpawnType s:SpawnType.values()){
            if(s.inbounds(rand))
                return s;
        }
        return SpawnType.BLANK;
    }
    
}
