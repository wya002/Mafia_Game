package game.player.citizen;

public class Citizen {

	//public static final boolean	isAlived = true;
	public int voteCount = 0;
	
	public Citizen() {
		
	}
	
	public void vote(Citizen playerNumber) {
		// 플레이어 지목!
		playerNumber.voteCount += 1;
		
		//	
	}
}
