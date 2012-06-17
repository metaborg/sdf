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

@SuppressWarnings("all") final class lifted558 extends Strategy 
{ 
  public static final lifted558 instance = new lifted558();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2082:
    { 
      term = collect_om_1_0.instance.invoke(context, term, lifted559.instance);
      if(term == null)
        break Fail2082;
      term = map_1_0.instance.invoke(context, term, expand_multi_line_template_production_0_0.instance);
      if(term == null)
        break Fail2082;
      if(true)
        return term;
    }
    return null;
  }
}