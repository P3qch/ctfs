package a.m;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class d {
    public abstract void a(f fVar);

    public abstract b b();

    public abstract void c(f fVar);

    public d() {
        new AtomicReference();
    }

    /* loaded from: classes.dex */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static a a(b state) {
            switch (state.ordinal()) {
                case 2:
                    return ON_DESTROY;
                case 3:
                    return ON_STOP;
                case 4:
                    return ON_PAUSE;
                default:
                    return null;
            }
        }

        public static a c(b state) {
            switch (state.ordinal()) {
                case 1:
                    return ON_CREATE;
                case 2:
                    return ON_START;
                case 3:
                    return ON_RESUME;
                default:
                    return null;
            }
        }

        public b b() {
            switch (this) {
                case ON_CREATE:
                case ON_STOP:
                    return b.CREATED;
                case ON_START:
                case ON_PAUSE:
                    return b.STARTED;
                case ON_RESUME:
                    return b.RESUMED;
                case ON_DESTROY:
                    return b.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean a(b state) {
            return compareTo(state) >= 0;
        }
    }
}
