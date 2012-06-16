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

@SuppressWarnings("all") final class lifted14 extends Strategy 
{ 
  Strategy t_10714;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail246:
    { 
      lifted15 lifted150 = new lifted15();
      lifted150.t_10714 = t_10714;
      term = repeat_1_0.instance.invoke(context, term, lifted150);
      if(term == null)
        break Fail246;
      if(true)
        return term;
    }
    return null;
  }
}