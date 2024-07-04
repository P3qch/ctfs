package a.g.b;

import a.h.j.f;
import a.h.j.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final f<ArrayList<T>> f333a = new g(10);

    /* renamed from: b, reason: collision with root package name */
    public final a.e.g<T, ArrayList<T>> f334b = new a.e.g<>();
    public final ArrayList<T> c = new ArrayList<>();
    public final HashSet<T> d = new HashSet<>();

    /* JADX WARN: Generic types in debug info not equals: a.g.b.a != androidx.coordinatorlayout.widget.DirectedAcyclicGraph<T> */
    public void b(T node) {
        if (!this.f334b.containsKey(node)) {
            this.f334b.put(node, null);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: a.g.b.a != androidx.coordinatorlayout.widget.DirectedAcyclicGraph<T> */
    public boolean d(T node) {
        return this.f334b.containsKey(node);
    }

    /* JADX WARN: Generic types in debug info not equals: a.g.b.a != androidx.coordinatorlayout.widget.DirectedAcyclicGraph<T> */
    public void a(T node, T incomingEdge) {
        if (!this.f334b.containsKey(node) || !this.f334b.containsKey(incomingEdge)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList<T> edges = this.f334b.get(node);
        if (edges == null) {
            edges = f();
            this.f334b.put(node, edges);
        }
        edges.add(incomingEdge);
    }

    /* JADX WARN: Generic types in debug info not equals: a.g.b.a != androidx.coordinatorlayout.widget.DirectedAcyclicGraph<T> */
    public List g(T node) {
        return this.f334b.get(node);
    }

    /* JADX WARN: Generic types in debug info not equals: a.g.b.a != androidx.coordinatorlayout.widget.DirectedAcyclicGraph<T> */
    public List<T> h(T node) {
        ArrayList<T> result = null;
        int size = this.f334b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> edges = this.f334b.m(i);
            if (edges != null && edges.contains(node)) {
                if (result == null) {
                    result = new ArrayList<>();
                }
                result.add(this.f334b.i(i));
            }
        }
        return result;
    }

    /* JADX WARN: Generic types in debug info not equals: a.g.b.a != androidx.coordinatorlayout.widget.DirectedAcyclicGraph<T> */
    public boolean j(T node) {
        int size = this.f334b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> edges = this.f334b.m(i);
            if (edges != null && edges.contains(node)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Generic types in debug info not equals: a.g.b.a != androidx.coordinatorlayout.widget.DirectedAcyclicGraph<T> */
    public void c() {
        int size = this.f334b.size();
        for (int i = 0; i < size; i++) {
            ArrayList<T> edges = this.f334b.m(i);
            if (edges != null) {
                k(edges);
            }
        }
        this.f334b.clear();
    }

    /* JADX WARN: Generic types in debug info not equals: a.g.b.a != androidx.coordinatorlayout.widget.DirectedAcyclicGraph<T> */
    public ArrayList<T> i() {
        this.c.clear();
        this.d.clear();
        int size = this.f334b.size();
        for (int i = 0; i < size; i++) {
            e(this.f334b.i(i), this.c, this.d);
        }
        return this.c;
    }

    /* JADX WARN: Generic types in debug info not equals: a.g.b.a != androidx.coordinatorlayout.widget.DirectedAcyclicGraph<T> */
    public final void e(T node, ArrayList<T> result, HashSet<T> tmpMarked) {
        if (result.contains(node)) {
            return;
        }
        if (tmpMarked.contains(node)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        tmpMarked.add(node);
        ArrayList<T> edges = this.f334b.get(node);
        if (edges != null) {
            int size = edges.size();
            for (int i = 0; i < size; i++) {
                e(edges.get(i), result, tmpMarked);
            }
        }
        tmpMarked.remove(node);
        result.add(node);
    }

    /* JADX WARN: Generic types in debug info not equals: a.g.b.a != androidx.coordinatorlayout.widget.DirectedAcyclicGraph<T> */
    public final ArrayList<T> f() {
        ArrayList<T> list = this.f333a.b();
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }

    /* JADX WARN: Generic types in debug info not equals: a.g.b.a != androidx.coordinatorlayout.widget.DirectedAcyclicGraph<T> */
    public final void k(ArrayList<T> list) {
        list.clear();
        this.f333a.a(list);
    }
}
