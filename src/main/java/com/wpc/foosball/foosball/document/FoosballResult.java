package com.wpc.foosball.foosball.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="foosballresults")
public class FoosballResult {
	@Id
	private String _id;
    private String winners;
    private String others;
    private String gameDate;
    
    public FoosballResult(String winners, String others, String gameDate) {
        this.winners = winners;
        this.others = others;
        this.gameDate = gameDate;
    }
    
	public String getWinners() {
		return winners;
	}
	public void setWinners(String winners) {
		this.winners = winners;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getGameDate() {
		return gameDate;
	}
	public void setGameDate(String gameDate) {
		this.gameDate = gameDate;
	}
	public String get_id() {
		return _id;
	}
}
