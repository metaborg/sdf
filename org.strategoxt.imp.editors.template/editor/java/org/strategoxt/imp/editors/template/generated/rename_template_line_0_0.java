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

@SuppressWarnings("all") public class rename_template_line_0_0 extends Strategy 
{ 
  public static rename_template_line_0_0 instance = new rename_template_line_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("rename_template_line_0_0");
    Fail871:
    { 
      TermReference r_32748 = new TermReference();
      TermReference s_32748 = new TermReference();
      TermReference t_32748 = new TermReference();
      TermReference u_32748 = new TermReference();
      IStrategoTerm v_32748 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail871;
      IStrategoTerm arg180 = term.getSubterm(0);
      if(arg180.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg180).getConstructor())
        break Fail871;
      if(r_32748.value == null)
        r_32748.value = arg180.getSubterm(0);
      else
        if(r_32748.value != arg180.getSubterm(0) && !r_32748.value.match(arg180.getSubterm(0)))
          break Fail871;
      if(s_32748.value == null)
        s_32748.value = term.getSubterm(1);
      else
        if(s_32748.value != term.getSubterm(1) && !s_32748.value.match(term.getSubterm(1)))
          break Fail871;
      v_32748 = term;
      lifted227 lifted2270 = new lifted227();
      lifted2270.r_32748 = r_32748;
      lifted2270.s_32748 = s_32748;
      lifted2270.t_32748 = t_32748;
      lifted2270.u_32748 = u_32748;
      term = with_spxverify_2_0.instance.invoke(context, term, lifted2270, lifted230.instance);
      if(term == null)
        break Fail871;
      term = v_32748;
      if(t_32748.value == null || u_32748.value == null)
        break Fail871;
      term = termFactory.makeTuple(termFactory.makeAppl(Main._consLine_1, new IStrategoTerm[]{t_32748.value}), u_32748.value);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}