package net.sqlcipher.database;

/* loaded from: classes.dex */
public class SQLiteQueryStats {
    public long largestIndividualRowSize;
    public long totalQueryResultSize;

    public SQLiteQueryStats(long totalQueryResultSize, long largestIndividualRowSize) {
        this.totalQueryResultSize = 0L;
        this.largestIndividualRowSize = 0L;
        this.totalQueryResultSize = totalQueryResultSize;
        this.largestIndividualRowSize = largestIndividualRowSize;
    }

    public long getTotalQueryResultSize() {
        return this.totalQueryResultSize;
    }

    public long getLargestIndividualRowSize() {
        return this.largestIndividualRowSize;
    }
}
