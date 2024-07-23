package tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FusionChart {
	private String[] arcanaList = {
		"Fool",
		"Magician",
		"Priestess",
		"Empress",
		"Emperor",
		"Hierophant",
		"Love",
		"Chariot",
		"Justice",
		"Hermit",
		"Fortune",
		"Strength",
		"Hanged Man",
		"Death",
		"Temperance",
		"Devil",
		"Tower",
		"Star",
		"Moon",
		"Sun",
		"Judgement",
		"Faith",
		"Councillor"
	};
		
	private List<String> arcanaArray = Arrays.asList(arcanaList);
	/*
	 * Fool - 1
	 * Magi - 2
	 * Prie - 3
	 * Empress - 4
	 * Emperor - 5
	 * Hier - 6
	 * Love - 7
	 * Char - 8
	 * Just - 9
	 * Herm - 10
	 * 
	 * Fort - 11
	 * Stre - 12
	 * Hang - 13
	 * Deat - 14
	 * Temp - 15
	 * Devi - 16
	 * Towe - 17
	 * Star - 18
	 * Moon - 19
	 * Sun - 20
	 * 
	 * Judg - 21
	 * Fait - 22
	 * Coun - 23
	 */
	private Integer[][] fusionChartNonTreasure = {
			// If 0, switch the x and y
			{1,	14,	19,	13,	15,	10,	8,	19,	18,	3,	22,	14,	17,	12,	6,	15,	4,	2,	9,	9,	20,	23,	6},
			{0,	2,	15,	9,	22,	14,	16,	3,	5,	7,	9,	1,	4,	10,	8,	6,	15,	3,	7,	6,	12,	12,	19},
			{0,	0,	3,	5,	4,	2,	11,	6,	14,	15,	2,	16,	14,	2,	16,	19,	13,	10,	6,	8,	9,	9,	22},
			{0,	0,	0,	4,	9,	1,	21,	18,	7,	12,	10,	22,	3,	1,	22,	20,	5,	7,	11,	17,	5,	2,	13},
			{0,	0,	0,	0,	5,	11,	1,	22,	8,	6,	20,	17,	16,	10,	16,	9,	18,	7,	17,	21,	3,	3,	7},
			{0,	0,	0,	0,	0,	6,	12,	18,	13,	23,	9,	1,	20,	8,	14,	13,	21,	17,	3,	7,	22,	4,	9},
			{0,	0,	0,	0,	0,	0,	7,	15,	21,	8,	12,	14,	23,	15,	12,	19,	4,	22,	2,	4,	13,	17,	17},
			{0,	0,	0,	0,	0,	0,	0,	8,	19,	16,	23,	10,	1,	16,	12,	15,	11,	19,	7,	3,	-1,	7,	20},
			{0,	0,	0,	0,	0,	0,	0,	0,	9,	2,	5,	23,	7,	1,	5,	1,	20,	4,	16,	13,	-1,	13,	5},
			{0,	0,	0,	0,	0,	0,	0,	0,	0,	10,	18,	6,	18,	12,	12,	3,	21,	12,	3,	16,	5,	21,	22},
			{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	11,	22,	5,	18,	4,	6,	13,	16,	20,	18,	17,	23,	21},
			{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	12,	15,	6,	8,	14,	22,	19,	2,	19,	-1,	18,	4},
			{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	13,	19,	14,	11,	10,	9,	23,	6,	18,	16,	18},
			{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	14,	13,	8,	20,	23,	6,	3,	-1,	1,	2},
			{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	15,	1,	11,	20,	23,	2,	10,	10,	1},
			{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	16,	2,	12,	8,	10,	7,	8,	8},
			{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	17,	23,	10,	5,	19,	14,	14},
			{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	18,	15,	21,	11,	15,	20},
			{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	19,	4,	1,	20,	15},
			{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	20,	14,	5,	11},
			{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	21,	11,	16},
			{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	22,	3},
			{0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	0,	23},			
	};
	
	public String getArcana(Integer i) {
		return (i > 0)
				? arcanaArray.get(i - 1)
				: "None";
	}
	
	public String getFusionArcana(Integer i, Integer j) {
		int res = fusionChartNonTreasure[i][j];
		
		if (res == 0) {
			res = fusionChartNonTreasure[j][i];
		}
		
		return getArcana(res);
	}
	
	public String getFusionArcanaNonTreasure(String a1, String a2) {
		int i1 = arcanaArray.indexOf(a1);
		int i2 = arcanaArray.indexOf(a2);
		
		return getFusionArcana(i1, i2);
	}
}
