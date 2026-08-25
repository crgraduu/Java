package ro.ase.acs.classes;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

	public static void matchDayReport(List<HandballMatch> matches, String filename) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
			OutputStreamWriter streamWriter = new OutputStreamWriter(fileOutputStream);
			BufferedWriter writer = new BufferedWriter(streamWriter);
			for(HandballMatch handballMatch : matches) {
				writer.write(handballMatch.getHomeTeam() + " " +
						handballMatch.getGoalsHomeTeam() + " - " +
						handballMatch.getGoalsAwayTeam() + " " +
						handballMatch.getAwayTeam());
				writer.newLine();
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static List<HandballMatch> readFromCSV(String filename) {
		List<HandballMatch> matches = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(filename);
			InputStreamReader streamReader = new InputStreamReader(fileInputStream);
			BufferedReader reader = new BufferedReader(streamReader);
			String line;
			reader.readLine();
			while((line = reader.readLine())!=null)  {
				String[] parts = line.split(",");
				String homeTeam = parts[0].trim();
				String awayTeam = parts[1].trim();
				int goalsHomeTeam = Integer.parseInt(parts[2].trim());
				int goalsAwayTeam = Integer.parseInt(parts[3].trim());

				HandballMatch match = new HandballMatch();
				match.setHomeTeam(homeTeam);
				match.setAwayTeam(awayTeam);
				match.setGoalsHomeTeam(goalsHomeTeam);
				match.setGoalsAwayTeam(goalsAwayTeam);
				matches.add(match);
			}
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matches;
	}
	
	public static int secretInfo(String filename) {
        try {
            FileInputStream binaryInputStream = new FileInputStream(filename);
			DataInputStream dataInputStream = new DataInputStream(binaryInputStream);
			dataInputStream.skipBytes(12);
			return dataInputStream.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
	}
	
	public static void serialize(List<HandballMatch> matches, String filename) {
        try {
            FileOutputStream binaryOutputStream = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(binaryOutputStream);
			objectOutputStream.writeObject(matches);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static List<HandballMatch> deserialize(String filename) throws IOException {
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			List<HandballMatch> matches = (List<HandballMatch>) objectInputStream.readObject();
			objectInputStream.close();
			return matches;
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void writeHeader(String filename) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
            {
                bufferedWriter.write("NO, TEAM, PTS, GF, GA, GD");
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void writePoints(String filename, List<HandballMatch> matches) {
		Map<String, Integer> map = new HashMap<>();
		for(HandballMatch match : matches) {
			String homeTeam = match.getHomeTeam();
			String awayTeam = match.getAwayTeam();
			int goalsHomeTeam = match.getGoalsHomeTeam();
			int goalsAwayTeam = match.getGoalsAwayTeam();
			map.putIfAbsent(homeTeam, 0);
			map.putIfAbsent(awayTeam, 0);

			if(goalsHomeTeam > goalsAwayTeam) {
				map.put(homeTeam, map.get(homeTeam) + 3);
			}   else if(goalsHomeTeam < goalsAwayTeam) {
					map.put(awayTeam, map.get(awayTeam)+3);
				} else if(goalsHomeTeam == goalsAwayTeam) {
					map.put(homeTeam, map.get(homeTeam)+1);
					map.put(awayTeam, map.get(awayTeam)+1);
				}
		}
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true));
			{
				for(Map.Entry<String, Integer> entry : map.entrySet()) {
					bufferedWriter.write(entry.getKey() + ", " + entry.getValue());
					bufferedWriter.newLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writePointsAndGoals(String filename, List<HandballMatch> matches) {
		
	}
	
	public static void leagueTable(String filename, List<HandballMatch> matches) {
		
	}
	
	public static void specialLeagueTable(String filename, List<HandballMatch> matches) {
		
	}
}
