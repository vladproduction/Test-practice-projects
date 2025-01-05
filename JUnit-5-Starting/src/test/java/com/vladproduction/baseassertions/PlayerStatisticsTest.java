package com.vladproduction.baseassertions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerStatisticsTest {

    @Test
    public void testPayerNameEquals(){
        Player player1 = new Player("David", 32);
        Player player2 = new Player("David", 25);

        assertEquals(player1, player2);
    }

    @Test
    public void testPayerNameNotEquals(){
        Player player1 = new Player("John", 32);
        Player player2 = new Player("David", 25);

        assertNotEquals(player1, player2);
    }

    @Test
    public void testYoungerPlayerSame(){
        Player player1 = new Player("David", 32);
        Player player2 = new Player("David", 25);

        assertSame(player2, PlayerStatistics.getYoungerPlayer(player1, player2));
    }

    @Test
    public void testPlayerUnderThirty(){
        Player player1 = new Player("David", 29);
        PlayerStatistics playerStatistics = new PlayerStatistics(player1, 3,3);

        assertTrue(playerStatistics.underThirty());
    }

    @Test
    public void testPlayerUnderThirtyNegative(){
        Player player1 = new Player("David", 32);
        PlayerStatistics playerStatistics = new PlayerStatistics(player1, 3,3);

        assertFalse(playerStatistics.underThirty());
    }

    @Test
    public void testCsvRecordNullReturn(){
        Player player1 = new Player("David", 32);
        PlayerStatistics playerStatistics = new PlayerStatistics(player1, 0,0);

        assertNull(playerStatistics.createCsvRecords());
    }

    @Test
    public void testCsvRecordReturnNotNull(){
        Player player1 = new Player("David", 32);
        PlayerStatistics playerStatistics = new PlayerStatistics(player1, 3,4);

        assertNotNull(playerStatistics.createCsvRecords());
    }

    @Test
    public void testCsvStatsPerRecord(){
        Player player1 = new Player("David", 32);
        PlayerStatistics playerStatistics = new PlayerStatistics(player1, 10,20);
        Double[] expectedStats = {2d, 0.5d}; //Double[]{goalsPerGame(), gamesPerGoal()};

        assertArrayEquals(expectedStats, playerStatistics.createCsvRecords());
    }


}