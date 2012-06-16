package trans;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_sglr.*;
import org.strategoxt.stratego_gpp.*;
import org.strategoxt.stratego_xtc.*;
import org.strategoxt.stratego_aterm.*;
import org.strategoxt.stratego_sdf.*;
import org.strategoxt.strc.*;
import org.strategoxt.imp.editors.template.generated.*;
import org.strategoxt.java_front.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") final class lifted17 extends Strategy 
{ 
  public static final lifted17 instance = new lifted17();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail244:
    { 
      IStrategoList annos0 = term.getAnnotations();
      term = SRTS_one.instance.invoke(context, annos0, lifted18.instance);
      if(term == null)
        break Fail244;
      if(true)
        return term;
    }
    return null;
  }
}