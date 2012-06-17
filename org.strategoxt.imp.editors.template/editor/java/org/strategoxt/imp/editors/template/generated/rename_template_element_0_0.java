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

@SuppressWarnings("all") public class rename_template_element_0_0 extends Strategy 
{ 
  public static rename_template_element_0_0 instance = new rename_template_element_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("rename_template_element_0_0");
    Fail872:
    { 
      IStrategoTerm w_32748 = null;
      IStrategoTerm x_32748 = null;
      IStrategoTerm y_32748 = null;
      IStrategoTerm z_32748 = null;
      TermReference a_32749 = new TermReference();
      TermReference b_32749 = new TermReference();
      TermReference c_32749 = new TermReference();
      IStrategoTerm d_32749 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail872;
      IStrategoTerm arg181 = term.getSubterm(0);
      if(arg181.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg181).getConstructor())
        break Fail872;
      w_32748 = arg181.getSubterm(0);
      x_32748 = arg181.getSubterm(1);
      y_32748 = arg181.getSubterm(2);
      z_32748 = arg181.getSubterm(3);
      if(b_32749.value == null)
        b_32749.value = term.getSubterm(1);
      else
        if(b_32749.value != term.getSubterm(1) && !b_32749.value.match(term.getSubterm(1)))
          break Fail872;
      d_32749 = term;
      lifted231 lifted2310 = new lifted231();
      lifted2310.a_32749 = a_32749;
      lifted2310.b_32749 = b_32749;
      lifted2310.c_32749 = c_32749;
      term = with_spxverify_2_0.instance.invoke(context, term, lifted2310, lifted232.instance);
      if(term == null)
        break Fail872;
      term = d_32749;
      if(a_32749.value == null || c_32749.value == null)
        break Fail872;
      term = termFactory.makeTuple(termFactory.annotateTerm(termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{w_32748, x_32748, y_32748, z_32748}), checkListAnnos(termFactory, (IStrategoTerm)termFactory.makeListCons(a_32749.value, (IStrategoList)generated.constNil3))), c_32749.value);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}