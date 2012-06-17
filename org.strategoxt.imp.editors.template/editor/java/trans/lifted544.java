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

@SuppressWarnings("all") final class lifted544 extends Strategy 
{ 
  Strategy g_33000;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2094:
    { 
      lifted545 lifted5450 = new lifted545();
      lifted5450.g_33000 = g_33000;
      term = repeat_1_0.instance.invoke(context, term, lifted5450);
      if(term == null)
        break Fail2094;
      if(true)
        return term;
    }
    return null;
  }
}