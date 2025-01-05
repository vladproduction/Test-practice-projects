package com.vladproduction.baseassertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerStatisticsBeforeTest {

    private Player player1;
    private Player player2;
    private Player player3;
    private PlayerStatistics playerStatisticsUnderThirty;
    private PlayerStatistics playerStatisticsAboveThirty;
    private PlayerStatistics playerStatisticsNoGames;
    private PlayerStatistics playerStatisticsWithGames;

    @BeforeEach
    public void setup(){
        player1 = new Player("David", 32);
        player2 = new Player("David", 25);
        player3 = new Player("John", 25);
        playerStatisticsUnderThirty = new PlayerStatistics(player2, 3,3);
        playerStatisticsAboveThirty = new PlayerStatistics(player1, 3,3);
        playerStatisticsNoGames = new PlayerStatistics(player1, 0,0);
        playerStatisticsWithGames = new PlayerStatistics(player1, 10,20);
    }

    @Test
    public void testPayerNameEquals(){
        assertEquals(player1, player2);
    }
    @Test
    public void testPlayersWithSameNameAreEqual() {
        assertEquals(player1, player2);
    }

    @Test
    public void testPayerNameNotEquals(){
        assertNotEquals(player1, player3);
    }
    @Test
    public void testPlayersWithDifferentNamesAreNotEqual() {
        assertNotEquals(player1, player3);
    }

    @Test
    public void testYoungerPlayerSame(){
        assertSame(player2, PlayerStatistics.getYoungerPlayer(player1, player2));
    }
    @Test
    public void testYoungerPlayerIsReturnedCorrectly() {
        assertSame(player2, PlayerStatistics.getYoungerPlayer(player1, player2));
    }

    @Test
    public void testPlayerUnderThirtyPositive(){
        assertTrue(playerStatisticsUnderThirty.underThirty());
    }
    @Test
    public void testUnderThirtyReturnsTrueForPlayerUnderThirty() {
        assertTrue(playerStatisticsUnderThirty.underThirty());
    }

    @Test
    public void testPlayerUnderThirtyNegative(){
        assertFalse(playerStatisticsAboveThirty.underThirty()); //expected as method return false, so assert false as well
    }
    @Test
    public void testUnderThirtyReturnsFalseForPlayerOverThirty() {
        assertFalse(playerStatisticsAboveThirty.underThirty());
    }

    @Test
    public void testCsvRecordNullReturn(){
        assertNull(playerStatisticsNoGames.createCsvRecords());//assume player has no games, so csv is null expected
    }
    @Test
    public void testCsvRecordsReturnNullForNoGames() {
        assertNull(playerStatisticsNoGames.createCsvRecords());
    }

    @Test
    public void testCsvRecordReturnNotNull(){
        assertNotNull(playerStatisticsWithGames.createCsvRecords());//assume player has some games, so csv with result expected
    }
    @Test
    public void testCsvRecordsReturnNotNullForGamesPlayed() {
        assertNotNull(playerStatisticsWithGames.createCsvRecords());
    }

    @Test
    public void testCsvStatsPerRecord(){
        Double[] expectedStats = {2d, 0.5d}; //Double[]{goalsPerGame(), gamesPerGoal()};
        assertArrayEquals(expectedStats, playerStatisticsWithGames.createCsvRecords()); //dive deeper into array result calculation expected
    }
    @Test
    public void testCsvStatsPerRecordReturnsCorrectValues() {
        Double[] expectedStats = {2.0, 0.5}; // goalsPerGame, gamesPerGoal
        assertArrayEquals(expectedStats, playerStatisticsWithGames.createCsvRecords());
    }

}