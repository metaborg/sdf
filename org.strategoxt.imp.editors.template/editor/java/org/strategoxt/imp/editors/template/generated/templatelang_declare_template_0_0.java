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

@SuppressWarnings("all") public class templatelang_declare_template_0_0 extends Strategy 
{ 
  public static templatelang_declare_template_0_0 instance = new templatelang_declare_template_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("templatelang_declare_template_0_0");
    Fail1110:
    { 
      IStrategoTerm term542 = term;
      Success467:
      { 
        Fail1111:
        { 
          TermReference q_32778 = new TermReference();
          TermReference r_32778 = new TermReference();
          TermReference s_32778 = new TermReference();
          TermReference t_32778 = new TermReference();
          TermReference u_32778 = new TermReference();
          IStrategoTerm w_32778 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
            break Fail1111;
          IStrategoTerm arg598 = term.getSubterm(0);
          if(u_32778.value == null)
            u_32778.value = arg598;
          else
            if(u_32778.value != arg598 && !u_32778.value.match(arg598))
              break Fail1111;
          if(arg598.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg598).getConstructor())
            break Fail1111;
          if(r_32778.value == null)
            r_32778.value = arg598.getSubterm(0);
          else
            if(r_32778.value != arg598.getSubterm(0) && !r_32778.value.match(arg598.getSubterm(0)))
              break Fail1111;
          if(q_32778.value == null)
            q_32778.value = arg598.getSubterm(2);
          else
            if(q_32778.value != arg598.getSubterm(2) && !q_32778.value.match(arg598.getSubterm(2)))
              break Fail1111;
          w_32778 = term;
          lifted414 lifted4140 = new lifted414();
          lifted4140.q_32778 = q_32778;
          lifted4140.r_32778 = r_32778;
          lifted4140.s_32778 = s_32778;
          lifted4140.t_32778 = t_32778;
          lifted4140.u_32778 = u_32778;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted4140);
          if(term == null)
            break Fail1111;
          term = w_32778;
          if(true)
            break Success467;
        }
        term = term542;
        IStrategoTerm p_32778 = null;
        p_32778 = term;
        term = templatelang_not_desugared_0_1.instance.invoke(context, p_32778, generated.const235);
        if(term == null)
          break Fail1110;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}