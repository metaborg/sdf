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

@SuppressWarnings("all") public class once_$Is$Imported_0_0 extends Strategy 
{ 
  public static once_$Is$Imported_0_0 instance = new once_$Is$Imported_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("once_IsImported_0_0");
    Fail197:
    { 
      IStrategoTerm a_10736 = null;
      TermReference b_10736 = new TermReference();
      TermReference c_10736 = new TermReference();
      TermReference d_10736 = new TermReference();
      IStrategoTerm e_10736 = null;
      IStrategoTerm f_10736 = null;
      IStrategoTerm h_10736 = null;
      IStrategoTerm j_10736 = null;
      if(c_10736.value == null)
        c_10736.value = term;
      else
        if(c_10736.value != term && !c_10736.value.match(term))
          break Fail197;
      if(b_10736.value == null)
        b_10736.value = term;
      else
        if(b_10736.value != term && !b_10736.value.match(term))
          break Fail197;
      h_10736 = term;
      j_10736 = term;
      term = dr_lookup_rule_pointer_0_2.instance.invoke(context, j_10736, trans.const5, c_10736.value);
      if(term == null)
        break Fail197;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail197;
      a_10736 = term.getSubterm(0);
      f_10736 = term.getSubterm(1);
      e_10736 = term.getSubterm(2);
      term = a_10736;
      lifted63 lifted630 = new lifted63();
      lifted630.b_10736 = b_10736;
      lifted630.c_10736 = c_10736;
      lifted630.d_10736 = d_10736;
      term = split_fetch_1_0.instance.invoke(context, term, lifted630);
      if(term == null)
        break Fail197;
      term = conc_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail197;
      term = hashtable_put_0_2.instance.invoke(context, e_10736, f_10736, term);
      if(term == null)
        break Fail197;
      term = h_10736;
      if(d_10736.value == null)
        break Fail197;
      term = d_10736.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}