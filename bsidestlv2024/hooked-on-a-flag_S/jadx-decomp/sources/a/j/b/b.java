package a.j.b;

import a.j.b.a;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* loaded from: classes.dex */
public class b {

    /* loaded from: classes.dex */
    public interface a<T> {
    }

    /* renamed from: a.j.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0039b<T, V> {
    }

    /* JADX WARN: Generic types in debug info not equals: a.j.b.b$a != androidx.customview.widget.FocusStrategy$BoundsAdapter<T> */
    /* JADX WARN: Generic types in debug info not equals: a.j.b.b$b != androidx.customview.widget.FocusStrategy$CollectionAdapter<L, T> */
    /* JADX WARN: Generic types in debug info not equals: a.j.b.b$c != androidx.customview.widget.FocusStrategy$SequentialComparator<T> */
    public static <L, T> T d(L l, InterfaceC0039b<L, T> interfaceC0039b, a<T> aVar, T t, int i, boolean z, boolean z2) {
        int d = ((a.b) interfaceC0039b).d(l);
        ArrayList arrayList = new ArrayList(d);
        for (int i2 = 0; i2 < d; i2++) {
            arrayList.add(((a.b) interfaceC0039b).b(l, i2));
        }
        Collections.sort(arrayList, new c(z, aVar));
        switch (i) {
            case 1:
                return (T) f(t, arrayList, z2);
            case 2:
                return (T) e(t, arrayList, z2);
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
        }
    }

    public static <T> T e(T focused, ArrayList<T> focusables, boolean wrap) {
        int count = focusables.size();
        int position = (focused == null ? -1 : focusables.lastIndexOf(focused)) + 1;
        if (position < count) {
            return focusables.get(position);
        }
        if (wrap && count > 0) {
            return focusables.get(0);
        }
        return null;
    }

    public static <T> T f(T focused, ArrayList<T> focusables, boolean wrap) {
        int count = focusables.size();
        int position = (focused == null ? count : focusables.indexOf(focused)) - 1;
        if (position >= 0) {
            return focusables.get(position);
        }
        if (wrap && count > 0) {
            return focusables.get(count - 1);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static class c<T> implements Comparator<T> {

        /* renamed from: b, reason: collision with root package name */
        public final Rect f508b = new Rect();
        public final Rect c = new Rect();
        public final boolean d;
        public final a<T> e;

        /* JADX WARN: Generic types in debug info not equals: a.j.b.b$a != androidx.customview.widget.FocusStrategy$BoundsAdapter<T> */
        /* JADX WARN: Generic types in debug info not equals: a.j.b.b$c != androidx.customview.widget.FocusStrategy$SequentialComparator<T> */
        public c(boolean isLayoutRtl, a<T> aVar) {
            this.d = isLayoutRtl;
            this.e = aVar;
        }

        /* JADX WARN: Generic types in debug info not equals: a.j.b.b$c != androidx.customview.widget.FocusStrategy$SequentialComparator<T> */
        @Override // java.util.Comparator
        public int compare(T first, T second) {
            Rect firstRect = this.f508b;
            Rect secondRect = this.c;
            ((a.C0038a) this.e).b(first, firstRect);
            ((a.C0038a) this.e).b(second, secondRect);
            int i = firstRect.top;
            int i2 = secondRect.top;
            if (i < i2) {
                return -1;
            }
            if (i > i2) {
                return 1;
            }
            int i3 = firstRect.left;
            int i4 = secondRect.left;
            if (i3 < i4) {
                return this.d ? 1 : -1;
            }
            if (i3 > i4) {
                return this.d ? -1 : 1;
            }
            int i5 = firstRect.bottom;
            int i6 = secondRect.bottom;
            if (i5 < i6) {
                return -1;
            }
            if (i5 > i6) {
                return 1;
            }
            int i7 = firstRect.right;
            int i8 = secondRect.right;
            if (i7 < i8) {
                return this.d ? 1 : -1;
            }
            if (i7 > i8) {
                return this.d ? -1 : 1;
            }
            return 0;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.j.b.b$a != androidx.customview.widget.FocusStrategy$BoundsAdapter<T> */
    /* JADX WARN: Generic types in debug info not equals: a.j.b.b$b != androidx.customview.widget.FocusStrategy$CollectionAdapter<L, T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <L, T> T c(L focusables, InterfaceC0039b<L, T> interfaceC0039b, a<T> aVar, T focused, Rect focusedRect, int direction) {
        Rect bestCandidateRect = new Rect(focusedRect);
        switch (direction) {
            case 17:
                bestCandidateRect.offset(focusedRect.width() + 1, 0);
                break;
            case 33:
                bestCandidateRect.offset(0, focusedRect.height() + 1);
                break;
            case 66:
                bestCandidateRect.offset(-(focusedRect.width() + 1), 0);
                break;
            case 130:
                bestCandidateRect.offset(0, -(focusedRect.height() + 1));
                break;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        T closest = null;
        int count = ((a.b) interfaceC0039b).d(focusables);
        Rect focusableRect = new Rect();
        for (int i = 0; i < count; i++) {
            Object b2 = ((a.b) interfaceC0039b).b(focusables, i);
            if (b2 != focused) {
                ((a.C0038a) aVar).b(b2, focusableRect);
                if (h(direction, focusedRect, focusableRect, bestCandidateRect)) {
                    bestCandidateRect.set(focusableRect);
                    closest = b2;
                }
            }
        }
        return closest;
    }

    public static boolean h(int direction, Rect source, Rect candidate, Rect currentBest) {
        if (!i(source, candidate, direction)) {
            return false;
        }
        if (!i(source, currentBest, direction) || a(direction, source, candidate, currentBest)) {
            return true;
        }
        if (a(direction, source, currentBest, candidate)) {
            return false;
        }
        int candidateDist = g(k(direction, source, candidate), o(direction, source, candidate));
        int currentBestDist = g(k(direction, source, currentBest), o(direction, source, currentBest));
        return candidateDist < currentBestDist;
    }

    public static boolean a(int direction, Rect source, Rect rect1, Rect rect2) {
        boolean rect1InSrcBeam = b(direction, source, rect1);
        boolean rect2InSrcBeam = b(direction, source, rect2);
        if (rect2InSrcBeam || !rect1InSrcBeam) {
            return false;
        }
        return !j(direction, source, rect2) || direction == 17 || direction == 66 || k(direction, source, rect1) < m(direction, source, rect2);
    }

    public static int g(int majorAxisDistance, int minorAxisDistance) {
        return (majorAxisDistance * 13 * majorAxisDistance) + (minorAxisDistance * minorAxisDistance);
    }

    public static boolean i(Rect srcRect, Rect destRect, int direction) {
        switch (direction) {
            case 17:
                int i = srcRect.right;
                int i2 = destRect.right;
                return (i > i2 || srcRect.left >= i2) && srcRect.left > destRect.left;
            case 33:
                int i3 = srcRect.bottom;
                int i4 = destRect.bottom;
                return (i3 > i4 || srcRect.top >= i4) && srcRect.top > destRect.top;
            case 66:
                int i5 = srcRect.left;
                int i6 = destRect.left;
                return (i5 < i6 || srcRect.right <= i6) && srcRect.right < destRect.right;
            case 130:
                int i7 = srcRect.top;
                int i8 = destRect.top;
                return (i7 < i8 || srcRect.bottom <= i8) && srcRect.bottom < destRect.bottom;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    public static boolean b(int direction, Rect rect1, Rect rect2) {
        switch (direction) {
            case 17:
            case 66:
                return rect2.bottom >= rect1.top && rect2.top <= rect1.bottom;
            case 33:
            case 130:
                return rect2.right >= rect1.left && rect2.left <= rect1.right;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    public static boolean j(int direction, Rect src, Rect dest) {
        switch (direction) {
            case 17:
                return src.left >= dest.right;
            case 33:
                return src.top >= dest.bottom;
            case 66:
                return src.right <= dest.left;
            case 130:
                return src.bottom <= dest.top;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    public static int k(int direction, Rect source, Rect dest) {
        return Math.max(0, l(direction, source, dest));
    }

    public static int l(int direction, Rect source, Rect dest) {
        switch (direction) {
            case 17:
                return source.left - dest.right;
            case 33:
                return source.top - dest.bottom;
            case 66:
                return dest.left - source.right;
            case 130:
                return dest.top - source.bottom;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    public static int m(int direction, Rect source, Rect dest) {
        return Math.max(1, n(direction, source, dest));
    }

    public static int n(int direction, Rect source, Rect dest) {
        switch (direction) {
            case 17:
                return source.left - dest.left;
            case 33:
                return source.top - dest.top;
            case 66:
                return dest.right - source.right;
            case 130:
                return dest.bottom - source.bottom;
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    public static int o(int direction, Rect source, Rect dest) {
        switch (direction) {
            case 17:
            case 66:
                return Math.abs((source.top + (source.height() / 2)) - (dest.top + (dest.height() / 2)));
            case 33:
            case 130:
                return Math.abs((source.left + (source.width() / 2)) - (dest.left + (dest.width() / 2)));
            default:
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }
}
