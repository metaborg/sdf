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

@SuppressWarnings("all") public class placeholder_to_pp_one_0_0 extends Strategy 
{ 
  public static placeholder_to_pp_one_0_0 instance = new placeholder_to_pp_one_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("placeholder_to_pp_one_0_0");
    Fail69:
    { 
      TermReference c_9714 = new TermReference();
      TermReference d_9714 = new TermReference();
      TermReference e_9714 = new TermReference();
      TermReference f_9714 = new TermReference();
      IStrategoTerm a_9715 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
        break Fail69;
      IStrategoTerm arg64 = term.getSubterm(1);
      if(arg64.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg64).getConstructor())
        break Fail69;
      if(e_9714.value == null)
        e_9714.value = arg64.getSubterm(0);
      else
        if(e_9714.value != arg64.getSubterm(0) && !e_9714.value.match(arg64.getSubterm(0)))
          break Fail69;
      if(c_9714.value == null)
        c_9714.value = term.getSubterm(3);
      else
        if(c_9714.value != term.getSubterm(3) && !c_9714.value.match(term.getSubterm(3)))
          break Fail69;
      a_9715 = term;
      lifted48 lifted480 = new lifted48();
      lifted480.c_9714 = c_9714;
      lifted480.d_9714 = d_9714;
      lifted480.e_9714 = e_9714;
      lifted480.f_9714 = f_9714;
      term = with_spxverify_2_0.instance.invoke(context, term, lifted480, lifted50.instance);
      if(term == null)
        break Fail69;
      term = a_9715;
      if(d_9714.value == null || f_9714.value == null)
        break Fail69;
      term = termFactory.makeAppl(Main._consCall_2, new IStrategoTerm[]{d_9714.value, (IStrategoTerm)termFactory.makeListCons(f_9714.value, (IStrategoList)generated.constNil0)});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}