package a.o.b;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public final a.e.g<RecyclerView.c0, a> f686a = new a.e.g<>();

    /* renamed from: b, reason: collision with root package name */
    public final a.e.d<RecyclerView.c0> f687b = new a.e.d<>();

    /* loaded from: classes.dex */
    public interface b {
    }

    public void f() {
        this.f686a.clear();
        this.f687b.b();
    }

    public void e(RecyclerView.c0 holder, RecyclerView.l.c info) {
        a record = this.f686a.get(holder);
        if (record == null) {
            record = a.b();
            this.f686a.put(holder, record);
        }
        record.c = info;
        record.f689b |= 4;
    }

    public boolean h(RecyclerView.c0 holder) {
        a record = this.f686a.get(holder);
        return (record == null || (record.f689b & 1) == 0) ? false : true;
    }

    public RecyclerView.l.c n(RecyclerView.c0 vh) {
        return l(vh, 4);
    }

    public RecyclerView.l.c m(RecyclerView.c0 vh) {
        return l(vh, 8);
    }

    public final RecyclerView.l.c l(RecyclerView.c0 vh, int flag) {
        a record;
        RecyclerView.l.c info;
        int index = this.f686a.f(vh);
        if (index >= 0 && (record = this.f686a.m(index)) != null) {
            int i = record.f689b;
            if ((i & flag) != 0) {
                int i2 = (flag ^ (-1)) & i;
                record.f689b = i2;
                if (flag == 4) {
                    info = record.c;
                } else if (flag == 8) {
                    info = record.d;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i2 & 12) == 0) {
                    this.f686a.k(index);
                    a.c(record);
                }
                return info;
            }
        }
        return null;
    }

    public void c(long key, RecyclerView.c0 holder) {
        this.f687b.i(key, holder);
    }

    public void a(RecyclerView.c0 holder, RecyclerView.l.c info) {
        a record = this.f686a.get(holder);
        if (record == null) {
            record = a.b();
            this.f686a.put(holder, record);
        }
        record.f689b |= 2;
        record.c = info;
    }

    public boolean i(RecyclerView.c0 viewHolder) {
        a record = this.f686a.get(viewHolder);
        return (record == null || (record.f689b & 4) == 0) ? false : true;
    }

    public RecyclerView.c0 g(long key) {
        return this.f687b.e(key);
    }

    public void d(RecyclerView.c0 holder, RecyclerView.l.c info) {
        a record = this.f686a.get(holder);
        if (record == null) {
            record = a.b();
            this.f686a.put(holder, record);
        }
        record.d = info;
        record.f689b |= 8;
    }

    public void b(RecyclerView.c0 holder) {
        a record = this.f686a.get(holder);
        if (record == null) {
            record = a.b();
            this.f686a.put(holder, record);
        }
        record.f689b |= 1;
    }

    public void p(RecyclerView.c0 holder) {
        a record = this.f686a.get(holder);
        if (record == null) {
            return;
        }
        record.f689b &= -2;
    }

    public void o(b callback) {
        for (int index = this.f686a.size() - 1; index >= 0; index--) {
            RecyclerView.c0 viewHolder = this.f686a.i(index);
            a record = this.f686a.k(index);
            int i = record.f689b;
            if ((i & 3) == 3) {
                ((RecyclerView.d) callback).d(viewHolder);
            } else if ((i & 1) != 0) {
                RecyclerView.l.c cVar = record.c;
                if (cVar == null) {
                    ((RecyclerView.d) callback).d(viewHolder);
                } else {
                    ((RecyclerView.d) callback).b(viewHolder, cVar, record.d);
                }
            } else if ((i & 14) == 14) {
                ((RecyclerView.d) callback).a(viewHolder, record.c, record.d);
            } else if ((i & 12) == 12) {
                ((RecyclerView.d) callback).c(viewHolder, record.c, record.d);
            } else if ((i & 4) != 0) {
                ((RecyclerView.d) callback).b(viewHolder, record.c, null);
            } else if ((i & 8) != 0) {
                ((RecyclerView.d) callback).a(viewHolder, record.c, record.d);
            }
            a.c(record);
        }
    }

    public void q(RecyclerView.c0 holder) {
        int i = this.f687b.l() - 1;
        while (true) {
            if (i < 0) {
                break;
            }
            if (holder != this.f687b.m(i)) {
                i--;
            } else {
                this.f687b.k(i);
                break;
            }
        }
        a info = this.f686a.remove(holder);
        if (info != null) {
            a.c(info);
        }
    }

    public void j() {
        a.a();
    }

    public void k(RecyclerView.c0 viewHolder) {
        p(viewHolder);
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static a.h.j.f<a> f688a = new a.h.j.g(20);

        /* renamed from: b, reason: collision with root package name */
        public int f689b;
        public RecyclerView.l.c c;
        public RecyclerView.l.c d;

        public static a b() {
            a record = f688a.b();
            return record == null ? new a() : record;
        }

        public static void c(a record) {
            record.f689b = 0;
            record.c = null;
            record.d = null;
            f688a.a(record);
        }

        public static void a() {
            do {
            } while (f688a.b() != null);
        }
    }
}
