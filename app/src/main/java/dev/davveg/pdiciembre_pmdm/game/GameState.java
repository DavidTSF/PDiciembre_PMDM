package dev.davveg.pdiciembre_pmdm.game;

public class GameState {
    PlayerCharacter playerCharacter;




    public GameState(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }
    public GameState() {
        this.playerCharacter = new PlayerCharacter();
    }




    public PlayerCharacter getPlayerCharacter() {
        return playerCharacter;
    }

    public void setPlayerCharacter(PlayerCharacter playerCharacter) {
        this.playerCharacter = playerCharacter;
    }
}
