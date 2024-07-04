package a.b.d.a;

import a.b.d.a.b;
import android.R;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.StateSet;

@SuppressLint({"RestrictedAPI"})
/* loaded from: classes.dex */
public class d extends b {
    public a n;
    public boolean o;

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // a.b.d.a.b, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] stateSet) {
        boolean changed = super.onStateChange(stateSet);
        int idx = this.n.A(stateSet);
        if (idx < 0) {
            idx = this.n.A(StateSet.WILD_CARD);
        }
        return g(idx) || changed;
    }

    public int[] k(AttributeSet attrs) {
        int j = 0;
        int numAttrs = attrs.getAttributeCount();
        int[] states = new int[numAttrs];
        for (int i = 0; i < numAttrs; i++) {
            int stateResId = attrs.getAttributeNameResource(i);
            switch (stateResId) {
                case 0:
                case R.attr.id:
                case R.attr.drawable:
                    break;
                default:
                    int j2 = j + 1;
                    states[j] = attrs.getAttributeBooleanValue(i, false) ? stateResId : -stateResId;
                    j = j2;
                    break;
            }
        }
        return StateSet.trimStateSet(states, j);
    }

    @Override // a.b.d.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.o) {
            super.mutate();
            if (this == this) {
                this.n.r();
                this.o = true;
            }
        }
        return this;
    }

    @Override // a.b.d.a.b
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public a b() {
        return new a(this.n, this, null);
    }

    /* loaded from: classes.dex */
    public static class a extends b.d {
        public int[][] J;

        public a(a orig, d owner, Resources res) {
            super(orig, owner, res);
            if (orig != null) {
                this.J = orig.J;
            } else {
                this.J = new int[f()];
            }
        }

        @Override // a.b.d.a.b.d
        public void r() {
            int[][] iArr = this.J;
            int[][] stateSets = new int[iArr.length];
            for (int i = iArr.length - 1; i >= 0; i--) {
                int[][] iArr2 = this.J;
                stateSets[i] = iArr2[i] != null ? (int[]) iArr2[i].clone() : null;
            }
            this.J = stateSets;
        }

        public int z(int[] stateSet, Drawable drawable) {
            int pos = a(drawable);
            this.J[pos] = stateSet;
            return pos;
        }

        public int A(int[] stateSet) {
            int[][] stateSets = this.J;
            int count = h();
            for (int i = 0; i < count; i++) {
                if (StateSet.stateSetMatches(stateSets[i], stateSet)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new d(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources res) {
            return new d(this, res);
        }

        @Override // a.b.d.a.b.d
        public void o(int oldSize, int newSize) {
            super.o(oldSize, newSize);
            int[][] newStateSets = new int[newSize];
            System.arraycopy(this.J, 0, newStateSets, 0, oldSize);
            this.J = newStateSets;
        }
    }

    @Override // a.b.d.a.b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // a.b.d.a.b
    public void h(b.d state) {
        super.h(state);
        if (state instanceof a) {
            this.n = (a) state;
        }
    }

    public d(a state, Resources res) {
        a newState = new a(state, this, res);
        h(newState);
        onStateChange(getState());
    }

    public d(a state) {
        if (state != null) {
            h(state);
        }
    }
}
