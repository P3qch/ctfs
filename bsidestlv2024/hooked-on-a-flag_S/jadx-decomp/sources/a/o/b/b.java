package a.o.b;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0047b f640a;

    /* renamed from: b, reason: collision with root package name */
    public final a f641b = new a();
    public final List<View> c = new ArrayList();

    /* renamed from: a.o.b.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0047b {
    }

    public b(InterfaceC0047b callback) {
        this.f640a = callback;
    }

    public final void l(View child) {
        this.c.add(child);
        ((RecyclerView.e) this.f640a).h(child);
    }

    public final boolean t(View child) {
        if (this.c.remove(child)) {
            ((RecyclerView.e) this.f640a).i(child);
            return true;
        }
        return false;
    }

    public void b(View child, boolean hidden) {
        a(child, -1, hidden);
    }

    public void a(View child, int index, boolean hidden) {
        int offset;
        if (index < 0) {
            offset = ((RecyclerView.e) this.f640a).e();
        } else {
            offset = h(index);
        }
        this.f641b.e(offset, hidden);
        if (hidden) {
            l(child);
        }
        ((RecyclerView.e) this.f640a).a(child, offset);
    }

    public final int h(int index) {
        if (index < 0) {
            return -1;
        }
        int limit = ((RecyclerView.e) this.f640a).e();
        int offset = index;
        while (offset < limit) {
            int removedBefore = this.f641b.b(offset);
            int diff = index - (offset - removedBefore);
            if (diff == 0) {
                while (this.f641b.d(offset)) {
                    offset++;
                }
                return offset;
            }
            offset += diff;
        }
        return -1;
    }

    public void p(View view) {
        int index = ((RecyclerView.e) this.f640a).g(view);
        if (index < 0) {
            return;
        }
        if (this.f641b.f(index)) {
            t(view);
        }
        ((RecyclerView.e) this.f640a).k(index);
    }

    public void q(int index) {
        int offset = h(index);
        View view = ((RecyclerView.e) this.f640a).d(offset);
        if (view == null) {
            return;
        }
        if (this.f641b.f(offset)) {
            t(view);
        }
        ((RecyclerView.e) this.f640a).k(offset);
    }

    public View f(int index) {
        int offset = h(index);
        return ((RecyclerView.e) this.f640a).d(offset);
    }

    public void o() {
        this.f641b.g();
        for (int i = this.c.size() - 1; i >= 0; i--) {
            ((RecyclerView.e) this.f640a).i(this.c.get(i));
            this.c.remove(i);
        }
        ((RecyclerView.e) this.f640a).j();
    }

    public View e(int position) {
        int count = this.c.size();
        for (int i = 0; i < count; i++) {
            View view = this.c.get(i);
            RecyclerView.c0 holder = ((RecyclerView.e) this.f640a).f(view);
            if (holder.m() == position && !holder.t() && !holder.v()) {
                return view;
            }
        }
        return null;
    }

    public void c(View child, int index, ViewGroup.LayoutParams layoutParams, boolean hidden) {
        int offset;
        if (index < 0) {
            offset = ((RecyclerView.e) this.f640a).e();
        } else {
            offset = h(index);
        }
        this.f641b.e(offset, hidden);
        if (hidden) {
            l(child);
        }
        ((RecyclerView.e) this.f640a).b(child, offset, layoutParams);
    }

    public int g() {
        return ((RecyclerView.e) this.f640a).e() - this.c.size();
    }

    public int j() {
        return ((RecyclerView.e) this.f640a).e();
    }

    public View i(int index) {
        return ((RecyclerView.e) this.f640a).d(index);
    }

    public void d(int index) {
        int offset = h(index);
        this.f641b.f(offset);
        ((RecyclerView.e) this.f640a).c(offset);
    }

    public int m(View child) {
        int index = ((RecyclerView.e) this.f640a).g(child);
        if (index == -1 || this.f641b.d(index)) {
            return -1;
        }
        return index - this.f641b.b(index);
    }

    public boolean n(View view) {
        return this.c.contains(view);
    }

    public void k(View view) {
        int offset = ((RecyclerView.e) this.f640a).g(view);
        if (offset < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f641b.h(offset);
        l(view);
    }

    public void s(View view) {
        int offset = ((RecyclerView.e) this.f640a).g(view);
        if (offset < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (!this.f641b.d(offset)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        this.f641b.a(offset);
        t(view);
    }

    public String toString() {
        return this.f641b.toString() + ", hidden list:" + this.c.size();
    }

    public boolean r(View view) {
        int index = ((RecyclerView.e) this.f640a).g(view);
        if (index == -1) {
            t(view);
            return true;
        }
        if (this.f641b.d(index)) {
            this.f641b.f(index);
            t(view);
            ((RecyclerView.e) this.f640a).k(index);
            return true;
        }
        return false;
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f642a = 0;

        /* renamed from: b, reason: collision with root package name */
        public a f643b;

        public void h(int index) {
            if (index >= 64) {
                c();
                this.f643b.h(index - 64);
            } else {
                this.f642a |= 1 << index;
            }
        }

        public final void c() {
            if (this.f643b == null) {
                this.f643b = new a();
            }
        }

        public void a(int index) {
            if (index >= 64) {
                a aVar = this.f643b;
                if (aVar != null) {
                    aVar.a(index - 64);
                    return;
                }
                return;
            }
            this.f642a &= (1 << index) ^ (-1);
        }

        public boolean d(int index) {
            if (index < 64) {
                return (this.f642a & (1 << index)) != 0;
            }
            c();
            return this.f643b.d(index - 64);
        }

        public void g() {
            this.f642a = 0L;
            a aVar = this.f643b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void e(int index, boolean value) {
            if (index >= 64) {
                c();
                this.f643b.e(index - 64, value);
                return;
            }
            long j = this.f642a;
            boolean lastBit = (Long.MIN_VALUE & j) != 0;
            long mask = (1 << index) - 1;
            long before = j & mask;
            long after = (j & ((-1) ^ mask)) << 1;
            this.f642a = before | after;
            if (value) {
                h(index);
            } else {
                a(index);
            }
            if (lastBit || this.f643b != null) {
                c();
                this.f643b.e(0, lastBit);
            }
        }

        public boolean f(int index) {
            if (index >= 64) {
                c();
                return this.f643b.f(index - 64);
            }
            long mask = 1 << index;
            long j = this.f642a;
            boolean value = (j & mask) != 0;
            long j2 = j & (mask ^ (-1));
            this.f642a = j2;
            long mask2 = mask - 1;
            long before = j2 & mask2;
            long after = Long.rotateRight(j2 & ((-1) ^ mask2), 1);
            this.f642a = before | after;
            a aVar = this.f643b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f643b.f(0);
            }
            return value;
        }

        public int b(int index) {
            a aVar = this.f643b;
            if (aVar == null) {
                if (index >= 64) {
                    return Long.bitCount(this.f642a);
                }
                return Long.bitCount(this.f642a & ((1 << index) - 1));
            }
            if (index < 64) {
                return Long.bitCount(this.f642a & ((1 << index) - 1));
            }
            return aVar.b(index - 64) + Long.bitCount(this.f642a);
        }

        public String toString() {
            if (this.f643b == null) {
                return Long.toBinaryString(this.f642a);
            }
            return this.f643b.toString() + "xx" + Long.toBinaryString(this.f642a);
        }
    }
}
