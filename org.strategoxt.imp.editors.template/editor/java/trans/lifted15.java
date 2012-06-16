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

@SuppressWarnings("all") final class lifted15 extends Strategy 
{ 
  Strategy t_10714;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail247:
    { 
      lifted16 lifted160 = new lifted16();
      lifted160.t_10714 = t_10714;
      term = preserve_annos_1_0.instance.invoke(context, term, lifted160);
      if(term == null)
        break Fail247;
      if(true)
        return term;
    }
    return null;
  }
}