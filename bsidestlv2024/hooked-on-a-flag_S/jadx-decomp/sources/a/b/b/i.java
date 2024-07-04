package a.b.b;

import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final Deque<WeakReference<XmlPullParser>> f42a = new ArrayDeque();

    public boolean a(AttributeSet attrs) {
        if (attrs instanceof XmlPullParser) {
            XmlPullParser xmlAttrs = (XmlPullParser) attrs;
            if (xmlAttrs.getDepth() == 1) {
                XmlPullParser ancestorXmlAttrs = c(this.f42a);
                this.f42a.push(new WeakReference<>(xmlAttrs));
                return d(xmlAttrs, ancestorXmlAttrs);
            }
            return false;
        }
        return false;
    }

    public static boolean d(XmlPullParser parser, XmlPullParser previousParser) {
        if (previousParser != null && parser != previousParser) {
            try {
                if (previousParser.getEventType() == 2) {
                    return "include".equals(previousParser.getName());
                }
                return false;
            } catch (XmlPullParserException e) {
                return false;
            }
        }
        return false;
    }

    public static XmlPullParser c(Deque<WeakReference<XmlPullParser>> xmlParserStack) {
        while (!xmlParserStack.isEmpty()) {
            XmlPullParser parser = xmlParserStack.peek().get();
            if (b(parser)) {
                xmlParserStack.pop();
            } else {
                return parser;
            }
        }
        return null;
    }

    public static boolean b(XmlPullParser parser) {
        if (parser != null) {
            try {
                if (parser.getEventType() != 3) {
                    return parser.getEventType() == 1;
                }
                return true;
            } catch (XmlPullParserException e) {
                return true;
            }
        }
        return true;
    }
}
