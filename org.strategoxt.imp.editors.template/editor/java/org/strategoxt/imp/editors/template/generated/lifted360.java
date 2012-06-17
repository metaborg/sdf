package org.strategoxt.imp.editors.template.generated;

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

@SuppressWarnings("all") final class lifted360 extends Strategy 
{ 
  TermReference x_32770;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1657:
    { 
      term = get_templates_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1657;
      term = filter_1_0.instance.invoke(context, term, expand_multi_line_template_production_0_0.instance);
      if(term == null)
        break Fail1657;
      term = choose_one_expansion_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1657;
      lifted362 lifted3620 = new lifted362();
      lifted3620.x_32770 = x_32770;
      term = map_1_0.instance.invoke(context, term, lifted3620);
      if(term == null)
        break Fail1657;
      if(true)
        return term;
    }
    return null;
  }
}