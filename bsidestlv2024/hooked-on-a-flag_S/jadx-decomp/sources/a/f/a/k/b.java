package a.f.a.k;

import java.util.ArrayList;

/* loaded from: classes.dex */
public class b {
    public static void b(f constraintWidgetContainer, a.f.a.d system, ArrayList<e> arrayList, int orientation) {
        int offset;
        int chainsSize;
        c[] chainsArray;
        if (orientation == 0) {
            offset = 0;
            chainsSize = constraintWidgetContainer.D0;
            chainsArray = constraintWidgetContainer.G0;
        } else {
            offset = 2;
            chainsSize = constraintWidgetContainer.E0;
            chainsArray = constraintWidgetContainer.F0;
        }
        for (int i = 0; i < chainsSize; i++) {
            c first = chainsArray[i];
            first.a();
            if (arrayList == null || arrayList.contains(first.f270a)) {
                a(constraintWidgetContainer, system, orientation, offset, first);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0655  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0660  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0669  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0692  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0685  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x066c  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0663  */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r2v83 */
    /* JADX WARN: Type inference failed for: r2v84 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(a.f.a.k.f r45, a.f.a.d r46, int r47, int r48, a.f.a.k.c r49) {
        /*
            Method dump skipped, instructions count: 1737
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.f.a.k.b.a(a.f.a.k.f, a.f.a.d, int, int, a.f.a.k.c):void");
    }
}
