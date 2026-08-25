package ro.ase.acs.classes;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Stream;

public class Utils {
	public static DataSeriesOperation anonymousOperation = new DataSeriesOperation() {
		@Override
		public Double doOperation (Integer[] values)  {
			if (values == null || values.length == 0)
				return 0.0;

			double product = 1.0;
			for (Integer value : values) {
				if (value != null)
				product *= value;
			}
			return product;
		}
	};
	
	public static DataSeriesOperation lambdaOperation = (values )-> {
		if (values == null || values.length == 0)
			return 0.0;
		double sum = 0.0;
		int count = 0;

		for (Integer value : values) {
			if (value != null) {
				sum = sum + value;
				count++;
			}
		}
		if(count == 0)
			return 0.0;
		else
		return sum/count;
	} ;
	
	public static Integer[] input = new Integer[] { 2, 5, 7 };
	
	public static Double result = null;
	
	public static Runnable runnable = null;
	
	public static Callable<Double> callable = null;
	
	public static Stream<String> getCardsBySuit(List<String> cards, char suit) {
		 if(cards == null )
			 return Stream.empty();
		 return cards.stream().filter(card -> card != null && card.length() == 2).filter(card -> card.charAt(1) == suit);
	}
	
	public static Stream<String> getCardsByRank(List<String> cards, char rank) {
		if(cards == null )
			return Stream.empty();
		return cards.stream().filter(card -> card != null && card.length() == 2).filter(card -> card.charAt(0) == rank).distinct().sorted();
	}
	
	public static Stream<String> getCardsLowerThan(List<String> cards, char rank) {
		if(cards == null )
			return Stream.empty();
		String rankOrder = "23456789TJQKA";
		int rankI = rankOrder.indexOf(rank);
		if(rankI == -1)
			return Stream.empty();
		return cards.stream().filter(card -> card != null && card.length() == 2).filter(card -> {
			char cardRank = card.charAt(0);
			int cardRankI = rankOrder.indexOf(cardRank);
			if(cardRankI != -1 && cardRankI < rankI)
			return true;
			else return false;
		} );
	}
	
	public static Stream<String> getCardsLowerThanSorted(List<String> cards, char rank) {
		if(cards == null )
			return Stream.empty();
		String rankOrder = "23456789TJQKA";
		String suitOrder = "SDHC";
		int rankI = rankOrder.indexOf(rank);
		if(rankI == -1)
			return Stream.empty();

		return cards.stream().filter(card -> card != null && card.length() == 2).filter(card -> {
			char cardRank = card.charAt(0);
			int cardRankI = rankOrder.indexOf(cardRank);
			if(cardRankI != -1 && cardRankI < rankI)
				return true;
			else return false;
		} )
				.sorted((card1,card2) -> {
					char suit1 = card1.charAt(1);
					char suit2 = card2.charAt(1);
					int suitI1 = suitOrder.indexOf(suit1);
					int suitI2 = suitOrder.indexOf(suit2);

					if(suitI1 != suitI2) {
						return Integer.compare(suitI1, suitI2);
					}

					char rank1 = card1.charAt(0);
					char rank2 = card2.charAt(0);
					return Integer.compare(rankOrder.indexOf(rank1), rankOrder.indexOf(rank2));
				});
	}
	
	public static String printDeckRanks(Stream<String> cards) {
		return null;
	}
}
