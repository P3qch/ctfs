package net.sqlcipher;

/* loaded from: classes.dex */
public class CustomCursorWindowAllocation implements CursorWindowAllocation {
    private long growthPaddingSize;
    private long initialAllocationSize;
    private long maxAllocationSize;

    public CustomCursorWindowAllocation(long initialSize, long growthPaddingSize, long maxAllocationSize) {
        this.initialAllocationSize = 0L;
        this.growthPaddingSize = 0L;
        this.maxAllocationSize = 0L;
        this.initialAllocationSize = initialSize;
        this.growthPaddingSize = growthPaddingSize;
        this.maxAllocationSize = maxAllocationSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getInitialAllocationSize() {
        return this.initialAllocationSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getGrowthPaddingSize() {
        return this.growthPaddingSize;
    }

    @Override // net.sqlcipher.CursorWindowAllocation
    public long getMaxAllocationSize() {
        return this.maxAllocationSize;
    }
}
