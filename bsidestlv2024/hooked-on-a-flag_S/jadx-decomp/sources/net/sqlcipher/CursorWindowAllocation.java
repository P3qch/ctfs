package net.sqlcipher;

/* loaded from: classes.dex */
public interface CursorWindowAllocation {
    long getGrowthPaddingSize();

    long getInitialAllocationSize();

    long getMaxAllocationSize();
}
